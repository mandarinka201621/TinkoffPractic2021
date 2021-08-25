package com.example.koshelok.data.repository

import android.content.Context
import com.example.koshelok.data.db.DetailWalletSourceImpl
import com.example.koshelok.data.extentions.checkDate
import com.example.koshelok.data.extentions.getFormattedDate
import com.example.koshelok.data.mappers.TransactionApiToDetailWalletTransactionMapper
import com.example.koshelok.data.mappers.WalletApiToHeaderWalletMapper
import com.example.koshelok.data.service.AppService
import com.example.koshelok.data.service.api.TransactionApi
import com.example.koshelok.domain.repository.DetailWalletRepository
import com.example.koshelok.ui.detailwallet.DetailWalletItem
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

class DetailWalletRepositoryImpl @Inject constructor(
    private val appService: AppService,
    private val mapperTransaction: TransactionApiToDetailWalletTransactionMapper,
    private val mapWallet: WalletApiToHeaderWalletMapper,
    private val context: Context,
    private val walletDbSource: DetailWalletSourceImpl
) :
    DetailWalletRepository {

    override fun getTransactions(walletId: Long): Observable<List<DetailWalletItem>> {
        return startLoadTransactions(walletId)
            .map {
                it.sortedByDescending { api -> api.time }
                    .groupBy { transactionApi -> transactionApi.time.getFormattedDate() }
            }
            .map { groupMap ->
                mutableListOf<DetailWalletItem>().apply {
                    groupMap.forEach { (key, transactions) ->
                        this.add(
                            DetailWalletItem.Day(
                                transactions.firstOrNull()?.time?.checkDate(context) ?: key
                            )
                        )
                        this.addAll(transactions.map(mapperTransaction))
                    }
                }
                    .toList()
                    .reversed()
            }
    }

    private fun startLoadTransactions(walletId: Long): Observable<List<TransactionApi>> {
        return Observable.create { emitter ->
            walletDbSource.getTransactions(walletId)
                .flatMap {
                    emitter.onNext(it)
                    return@flatMap appService.getTransactions(walletId)
                }.subscribe({ list ->
                    emitter.onNext(list)
                    walletDbSource.insertAllTransactions(list, walletId)
                }, {
                    emitter.onError(it)
                }
                )
        }
    }

    override fun getDataWallet(walletId: Long): Observable<DetailWalletItem.HeaderDetailWallet> {
        return Observable.create { emitter ->
            walletDbSource.getWallet(walletId)
                .flatMap {
                    emitter.onNext(mapWallet(it))
                    return@flatMap appService.getWallet(walletId).map(mapWallet)
                }
                .subscribe { header ->
                    emitter.onNext(header)
                }
        }
    }
}
