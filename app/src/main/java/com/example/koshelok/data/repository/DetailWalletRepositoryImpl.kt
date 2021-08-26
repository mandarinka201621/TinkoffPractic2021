package com.example.koshelok.data.repository

import android.content.Context
import com.example.koshelok.data.db.source.DetailWalletSource
import com.example.koshelok.data.db.source.WalletSource
import com.example.koshelok.data.extentions.checkDate
import com.example.koshelok.data.extentions.getFormattedDate
import com.example.koshelok.data.mappers.transactions.TransactionApiToDetailWalletTransactionMapper
import com.example.koshelok.data.mappers.wallets.WalletApiToHeaderWalletMapper
import com.example.koshelok.data.service.AppService
import com.example.koshelok.data.service.api.DetailWalletApi
import com.example.koshelok.domain.repository.DetailWalletRepository
import com.example.koshelok.ui.detailwallet.DetailWalletItem
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class DetailWalletRepositoryImpl @Inject constructor(
    private val appService: AppService,
    private val mapperTransaction: TransactionApiToDetailWalletTransactionMapper,
    private val mapWallet: WalletApiToHeaderWalletMapper,
    private val context: Context,
    private val walletSource: WalletSource,
    private val walletDbSource: DetailWalletSource,
) : DetailWalletRepository {

    override fun getDetailWalletData(walletId: Long): Observable<List<DetailWalletItem>> {
        return getDetailWalletDataApi(walletId).map { detailWallet ->
            val groupMap = detailWallet.transactions.sortedByDescending { api -> api.time }
                .groupBy { transactionApi -> transactionApi.time.getFormattedDate() }
            return@map mutableListOf<DetailWalletItem>().apply {
                add(mapWallet(detailWallet.walletApi))
                groupMap.forEach { (key, transactions) ->
                    this.add(
                        DetailWalletItem.Day(
                            transactions.firstOrNull()?.time?.checkDate(context) ?: key
                        )
                    )
                    this.addAll(transactions.map(mapperTransaction))
                }
            }.toList()
        }
    }

    private fun getDetailWalletDataApi(walletId: Long): Observable<DetailWalletApi> {
        return Observable.concat(
            walletDbSource.getDetailWallet(walletId)
                .toObservable(),
            getDetailWalletApi(walletId)
        )
    }

    private fun getDetailWalletApi(walletId: Long): Observable<DetailWalletApi> {
        return Observable.zip(
            appService.getWallet(walletId)
                .flatMap { wallet ->
                    Completable.fromCallable { walletSource.insertWallet(wallet = wallet) }
                        .subscribeOn(Schedulers.computation())
                        .andThen(Single.just(wallet))
                }.toObservable(),
            appService.getTransactions(walletId)
                .flatMap { it ->
                    Completable.fromCallable { walletDbSource.insertAllTransactions(it, walletId) }
                        .subscribeOn(Schedulers.computation())
                        .andThen(Single.just(it))
                }.toObservable()

        ) { wallet, transactions ->
            return@zip DetailWalletApi(wallet, transactions)
        }
    }
}
