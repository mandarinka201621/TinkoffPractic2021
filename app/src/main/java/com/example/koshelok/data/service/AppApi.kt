package com.example.koshelok.data.service

import com.example.koshelok.data.service.api.AnswerServerApi
import com.example.koshelok.data.service.api.BalanceApi
import com.example.koshelok.data.service.api.CategoryApi
import com.example.koshelok.data.service.api.CreateTransactionApi
import com.example.koshelok.data.service.api.ExchangeRatesApi
import com.example.koshelok.data.service.api.TransactionApi
import com.example.koshelok.data.service.api.WalletApi
import io.reactivex.rxjava3.core.Single
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT

interface AppApi {

    @GET("getWallets")
    fun getWallets(): Single<List<WalletApi>>

    @GET("getTransactions")
    fun getTransactions(walletId: Long): Single<List<TransactionApi>>

    @GET("getCategories")
    fun getCategories(): Single<List<CategoryApi>>

    @GET("getWallet")
    fun getWallet(walletId: Long): Single<WalletApi>

    @POST("addTransaction")
    fun addTransaction(transactionApi: CreateTransactionApi): Single<AnswerServerApi>

    @POST("addWallet")
    fun addWallet(walletApi: WalletApi): Single<AnswerServerApi>

    @PUT("editTransaction")
    fun editTransaction(transactionApi: CreateTransactionApi): Single<AnswerServerApi>

    @DELETE("deleteTransaction")
    fun deleteTransaction(id: Long): Single<AnswerServerApi>

    @GET("getBalance")
    fun getBalance(): Single<BalanceApi>

    @GET("getExchangeRates")
    fun getExchangeRates(): Single<ExchangeRatesApi>
}
