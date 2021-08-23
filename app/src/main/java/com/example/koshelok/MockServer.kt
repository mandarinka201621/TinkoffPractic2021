package com.example.koshelok

import com.example.koshelok.data.service.AppService
import com.example.koshelok.data.service.api.BalanceApi
import com.example.koshelok.data.service.api.CategoryApi
import com.example.koshelok.data.service.api.CreateTransactionApi
import com.example.koshelok.data.service.api.ExchangeRatesApi
import com.example.koshelok.data.service.api.ResponseApi
import com.example.koshelok.data.service.api.TransactionApi
import com.example.koshelok.data.service.api.WalletApi
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

@Suppress("MagicNumber")
class MockServer @Inject constructor() : AppService {
    override fun getWallets(idUser: Long): Single<List<WalletApi>> {
        TODO("Not yet implemented")
    }

    override fun getTransactions(walletId: Long): Single<List<TransactionApi>> {
        TODO("Not yet implemented")
    }

    override fun getCategories(personId: Long): Single<List<CategoryApi>> {
        TODO("Not yet implemented")
    }

    override fun getWallet(walletId: Long): Single<WalletApi> {
        TODO("Not yet implemented")
    }

    override fun addTransaction(transactionApi: CreateTransactionApi): Single<ResponseApi> {
        TODO("Not yet implemented")
    }

    override fun addWallet(walletApi: WalletApi): Single<ResponseApi> {
        TODO("Not yet implemented")
    }

    override fun editTransaction(
        id: Long,
        transactionApi: CreateTransactionApi
    ): Single<ResponseApi> {
        TODO("Not yet implemented")
    }

    override fun deleteTransaction(id: Long): Single<ResponseApi> {
        TODO("Not yet implemented")
    }

    override fun getBalance(personId: Long): Single<BalanceApi> {
        TODO("Not yet implemented")
    }

    override fun getExchangeRates(): Single<ExchangeRatesApi> {
        TODO("Not yet implemented")
    }

}
