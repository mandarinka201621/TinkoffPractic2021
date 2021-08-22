package com.example.koshelok.data.service.repimpl

import android.content.Context
import com.example.koshelok.data.extentions.checkDate
import com.example.koshelok.data.extentions.getDate
import com.example.koshelok.data.service.AppApi
import com.example.koshelok.data.service.Mapper
import com.example.koshelok.domain.repository.DetailWalletRepository
import com.example.koshelok.ui.detailwallet.DetailWalletItem
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class DetailWalletRepositoryImpl @Inject constructor(
    private val appApi: AppApi,
    private val mapper: Mapper,
    private val context: Context
) :
    DetailWalletRepository {

    override fun getTransactions(walletId: Long): Single<List<DetailWalletItem>> {
        return appApi.getTransactions(walletId)
            .map {
                it.sortedByDescending { api -> api.time }
                    .groupBy { transactionApi -> transactionApi.time.getDate() }
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
                            mapper.mapTransactionApiToDetailWalletTransaction(api)
                        })
                    }
                }.toList()
            }
    }

    override fun getDataWallet(walletId: Long): Single<DetailWalletItem.HeaderDetailWallet> {
        return appApi.getWallet(walletId)
            .map {
                mapper.mapWalletApiToHeaderWallet(it)
            }
    }
}
