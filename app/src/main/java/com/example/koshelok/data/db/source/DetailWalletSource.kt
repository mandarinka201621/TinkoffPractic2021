package com.example.koshelok.data.db.source

import com.example.koshelok.data.db.KoshelokDatabase
import com.example.koshelok.data.mappers.transactions.TransactionDbToTransactionApiMapper
import com.example.koshelok.data.mappers.transactions.TransactionsApiToTransactionsDbMapper
import com.example.koshelok.data.mappers.wallets.WalletDbToWalletApiMapper
import com.example.koshelok.data.service.api.TransactionApi
import com.example.koshelok.data.service.api.WalletApi
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

interface DetailWalletSource {

    fun getWallet(walletId: Long): Single<WalletApi>

    fun insertAllTransactions(wallets: List<TransactionApi>, walletId: Long)

    fun getTransactions(walletId: Long): Single<List<TransactionApi>>
}

class DetailWalletSourceImpl @Inject constructor(
    private val database: KoshelokDatabase,
    private val transactionsDbMapper: TransactionsApiToTransactionsDbMapper,
    private val transMapper: TransactionDbToTransactionApiMapper,
    private val walletMapper: WalletDbToWalletApiMapper
) : DetailWalletSource {


    override fun getWallet(walletId: Long): Single<WalletApi> {
        return database.getWalletsDao()
            .getWalletByWalletId(walletId)
            .map(walletMapper)
    }

    override fun getTransactions(walletId: Long): Single<List<TransactionApi>> {
        return database.getTransactionDao()
            .getTransactionsByWalletId(walletId)
            .map {
                it.map(transMapper)
            }
    }

    override fun insertAllTransactions(wallets: List<TransactionApi>, walletId: Long) {
        return database.getTransactionDao()
            .insertAllTransactions(
                wallets.map { transactionsDbMapper(it, walletId) }
            )
    }
}
