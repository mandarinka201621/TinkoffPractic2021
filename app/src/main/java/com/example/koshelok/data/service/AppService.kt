package com.example.koshelok.data.service

import com.example.koshelok.data.service.api.CategoryApi
import com.example.koshelok.data.service.api.CreateTransactionApi
import com.example.koshelok.data.service.api.MainScreenDataApi
import com.example.koshelok.data.service.api.ResponseApi
import com.example.koshelok.data.service.api.ResponseWithWalletIdApi
import com.example.koshelok.data.service.api.TransactionApi
import com.example.koshelok.data.service.api.WalletApi
import io.reactivex.rxjava3.core.Single
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface AppService {

    @GET("transactions/wallet/{walletId}")
    fun getTransactions(@Path("walletId") walletId: Long): Single<List<TransactionApi>>

    @GET("categories/person/{personId}")
    fun getCategories(@Path("personId") personId: Long): Single<List<CategoryApi>>

    @GET("wallets/{walletId}")
    fun getWallet(@Path("walletId") walletId: Long): Single<WalletApi>

    @POST("transactions")
    fun createTransaction(@Body transactionApi: CreateTransactionApi): Single<ResponseApi>

    @POST("wallets")
    fun createWallet(@Body walletApi: WalletApi): Single<ResponseWithWalletIdApi>

    @PUT("transactions/{transactionId}")
    fun editTransaction(
        @Path("transactionId")
        id: Long,
        @Body transactionApi: CreateTransactionApi
    ): Single<ResponseApi>

    @DELETE("transactions/{transactionId}")
    fun deleteTransaction(@Path("transactionId") id: Long): Single<ResponseApi>

    @GET("getMainScreen/{personId}")
    fun getDataForMainScreen(@Path("personId") personId: Long): Single<MainScreenDataApi>

    @GET("registration")
    fun registrationUser(email: String): Single<Long>
}
