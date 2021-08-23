package com.example.koshelok.data.repository

import android.content.Context
import com.example.koshelok.data.extentions.checkDate
import com.example.koshelok.data.extentions.getFormattedDate
import com.example.koshelok.data.mappers.TransactionApiToDetailWalletTransactionMapper
import com.example.koshelok.data.mappers.WalletApiToHeaderWalletMapper
import com.example.koshelok.data.service.AppService
import com.example.koshelok.domain.repository.DetailWalletRepository
import com.example.koshelok.ui.detailwallet.DetailWalletItem
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class DetailWalletRepositoryImpl @Inject constructor(
    private val appService: AppService,
    private val mapperTransaction: TransactionApiToDetailWalletTransactionMapper,
    private val mapWallet: WalletApiToHeaderWalletMapper,
    private val context: Context
) :
    DetailWalletRepository {

    override fun getTransactions(walletId: Long): Single<List<DetailWalletItem>> {
        return appService.getTransactions(walletId)
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
                        this.addAll(transactions.map { api ->
                            mapperTransaction(api)
                        })
                    }
                }.toList()
                    .reversed()
            }
    }

    override fun getDataWallet(walletId: Long): Single<DetailWalletItem.HeaderDetailWallet> {
        return appService.getWallet(walletId)
            .map {
                mapWallet(it)
            }
    }
}
