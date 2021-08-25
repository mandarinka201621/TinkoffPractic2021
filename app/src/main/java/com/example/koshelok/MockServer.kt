package com.example.koshelok

import com.example.koshelok.data.service.AppService
import com.example.koshelok.data.service.api.CategoryApi
import com.example.koshelok.data.service.api.CreateTransactionApi
import com.example.koshelok.data.service.api.MainScreenDataApi
import com.example.koshelok.data.service.api.TransactionApi
import com.example.koshelok.data.service.api.WalletApi
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

@Suppress("MagicNumber")
class MockServer @Inject constructor() : AppService {
    override fun getWallet(walletId: Long): Single<WalletApi> {
        TODO("Not yet implemented")
    }

    override fun createWallet(walletApi: WalletApi): Single<Long> {
        TODO("Not yet implemented")
    }

    override fun getDataForMainScreen(personId: Long): Single<MainScreenDataApi> {
        TODO("Not yet implemented")
    }

    override fun createTransaction(transactionApi: CreateTransactionApi): Completable {
        TODO("Not yet implemented")
    }

    override fun getTransactions(walletId: Long): Single<List<TransactionApi>> {
        TODO("Not yet implemented")
    }

    override fun editTransaction(id: Long, transactionApi: CreateTransactionApi): Completable {
        TODO("Not yet implemented")
    }

    override fun deleteTransaction(id: Long): Completable {
        TODO("Not yet implemented")
    }

    override fun getCategories(personId: Long, type: Int): Single<List<CategoryApi>> {
        TODO("Not yet implemented")
    }

    override fun createCategory(categoryApi: CategoryApi): Completable {
        TODO("Not yet implemented")
    }

    override fun registrationUser(email: String): Single<Long> {
        TODO("Not yet implemented")
    }

}
