package com.example.koshelok.data.db.source

import android.util.Log
import com.example.koshelok.data.db.KoshelokDatabase
import com.example.koshelok.data.mappers.DetailWalletDbToApiMapper
import com.example.koshelok.data.mappers.transactions.TransactionsApiToTransactionsDbMapper
import com.example.koshelok.data.service.api.DetailWalletApi
import com.example.koshelok.data.service.api.TransactionApi
import io.reactivex.rxjava3.core.Maybe
import javax.inject.Inject

interface DetailWalletSource {

    fun insertAllTransactions(wallets: List<TransactionApi>, walletId: Long)

    fun getDetailWallet(walletId: Long): Maybe<DetailWalletApi>

    fun deleteTransaction(transactionId: Long)
}

class DetailWalletSourceImpl @Inject constructor(
    private val database: KoshelokDatabase,
    private val transactionsDbMapper: TransactionsApiToTransactionsDbMapper,
    private val detailMapper: DetailWalletDbToApiMapper
) : DetailWalletSource {


    override fun insertAllTransactions(wallets: List<TransactionApi>, walletId: Long) {
        return database.getTransactionDao()
            .insertAllTransactions(
                wallets.map {
                    transactionsDbMapper(it, walletId)
                }
            )
    }

    override fun getDetailWallet(walletId: Long): Maybe<DetailWalletApi> {
        return database.getWalletsDao().getDetailWalletDb(walletId)
            .doOnSuccess {
                Log.d("tut_det", it.toString())
            }
            .map(detailMapper)
    }

    override fun deleteTransaction(transactionId: Long) {
        database.getTransactionDao().deleteTransactions(transactionId)
    }
}
