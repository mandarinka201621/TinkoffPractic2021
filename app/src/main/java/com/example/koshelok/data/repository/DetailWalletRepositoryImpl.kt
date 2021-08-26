package com.example.koshelok.data.repository

import android.content.Context
import com.example.koshelok.data.db.source.DetailWalletSource
import com.example.koshelok.data.db.source.WalletSource
import com.example.koshelok.data.extentions.checkDate
import com.example.koshelok.data.extentions.getFormattedDate
import com.example.koshelok.data.mappers.transactions.TransactionApiToDetailWalletTransactionMapper
import com.example.koshelok.data.mappers.wallets.WalletApiToHeaderWalletMapper
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
    private val walletDbSource: DetailWalletSource,
    private val walletSource: WalletSource
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
        return Observable.concat(
            walletDbSource.getTransactions(walletId).toObservable(),
            appService.getTransactions(walletId)
                .doOnSuccess { list ->
                    walletDbSource.insertAllTransactions(list, walletId)
                }.toObservable()
        )
            .distinctUntilChanged()
    }

    override fun getDataWallet(walletId: Long): Observable<DetailWalletItem.HeaderDetailWallet> {
        return Observable.concat(
            walletDbSource.getWallet(walletId).map(mapWallet).toObservable(),
            appService.getWallet(walletId)
                .doOnSuccess { walletApi ->
                    walletSource.insertWallet(walletApi)
                }.map(mapWallet).toObservable()
        ).distinctUntilChanged()
    }
}
