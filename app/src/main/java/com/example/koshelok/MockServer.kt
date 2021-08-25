package com.example.koshelok

import android.graphics.Color
import com.example.koshelok.data.service.AppService
import com.example.koshelok.data.service.api.BalanceApi
import com.example.koshelok.data.service.api.CategoryApi
import com.example.koshelok.data.service.api.CreateTransactionApi
import com.example.koshelok.data.service.api.ExchangeRatesApi
import com.example.koshelok.data.service.api.MainScreenDataApi
import com.example.koshelok.data.service.api.TransactionApi
import com.example.koshelok.data.service.api.WalletApi
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

@Suppress("MagicNumber")
class MockServer @Inject constructor() : AppService {
    val list =
        mutableListOf(
            TransactionApi(
                0, "1234", 0, 0, "Супермаркет", 0,
                Color.parseColor("#5833EE"), "RUB", 1243554646426
            ),
            TransactionApi(
                1, "34", 0, 0, "Супермаркет", 1,
                Color.parseColor("#5833EE"), "RUB", 1243554646426
            ),
            TransactionApi(
                2,
                "12534",
                0,
                0,
                "Супермаркет",
                2,
                Color.parseColor("#5833EE"),
                "RUB",
                1243554646426
            ),
            TransactionApi(
                3,
                "124",
                0,
                0,
                "Супермаркет",
                3,
                Color.parseColor("#5833EE"),
                "RUB",
                1243554646499
            ),
            TransactionApi(
                4,
                "13534",
                0,
                0,
                "Супермаркет",
                4,
                Color.parseColor("#5833EE"),
                "RUB",
                1243554546426
            ),
            TransactionApi(
                5,
                "11534",
                0,
                0,
                "Супермаркет",
                5,
                Color.parseColor("#5833EE"),
                "RUB",
                1243553446426
            ),
            TransactionApi(
                6,
                "34",
                0,
                0,
                "Супермаркет",
                6,
                Color.parseColor("#5833EE"),
                "RUB",
                1243554646526
            ),
            TransactionApi(
                7,
                "16432",
                0,
                0,
                "Супермаркет",
                1,
                Color.parseColor("#5833EE"),
                "RUB",
                1223554646426
            ),
            TransactionApi(
                8,
                "123",
                0,
                0,
                "Супермаркет",
                0,
                Color.parseColor("#5833EE"),
                "RUB",
                124354646426
            ),
            TransactionApi(
                9,
                "12784",
                0,
                0,
                "Супермаркет",
                4,
                Color.parseColor("#5833EE"),
                "RUB",
                1233554646426
            ),
            TransactionApi(
                10,
                "123423",
                0,
                0,
                "Супермаркет",
                2,
                Color.parseColor("#5833EE"),
                "RUB",
                1273554646426
            ),
        )

    override fun getTransactions(walletId: Long): Single<List<TransactionApi>> {
        return Single.just(list)
    }

    override fun getCategories(personId: Long): Single<List<CategoryApi>> {
        return Single.just(
            listOf(
                CategoryApi(
                    0,
                    0,
                    "Супермаркет",
                    4,
                    Color.parseColor("#5833EE")
                ),
                CategoryApi(
                    1,
                    1,
                    "Супермаркет1",
                    4,
                    Color.parseColor("#5833EE")
                ),
                CategoryApi(
                    2,
                    0,
                    "Супермаркет2",
                    4,
                    Color.parseColor("#5833EE")
                ),
                CategoryApi(
                    3,
                    1,
                    "Супермаркет3",
                    4,
                    Color.parseColor("#5833EE")
                )
            )
        )
    }

    override fun getWallet(walletId: Long): Single<WalletApi> {
        return Single.just(
            WalletApi(
                0, "Кошелек 1", "144325", "165623", "24521", "100000", "RUB", 0, false
            )
        )
    }

    override fun createTransaction(transactionApi: CreateTransactionApi): Completable {
        list.add(
            TransactionApi(
                300,
                transactionApi.money,
                transactionApi.idCategory,
                0,
                "Супермаркет",
                6,
                Color.parseColor("#5833EE"),
                transactionApi.currency,
                transactionApi.time
            )
        )
        return Completable.complete()
    }

    override fun createWallet(walletApi: WalletApi): Single<Long> {
        return Single.just(200)
    }

    override fun editTransaction(
        id: Long,
        transactionApi: CreateTransactionApi
    ): Completable {
        TODO("Not yet implemented")
    }

    override fun deleteTransaction(id: Long): Completable {
        TODO("Not yet implemented")
    }

    override fun getDataForMainScreen(personId: Long): Single<MainScreenDataApi> {
        return Single.just(
            MainScreenDataApi(
                BalanceApi(
                    "20000",
                    "23000",
                    "3000"
                ),
                ExchangeRatesApi(
                    "USD",
                    "73.22",
                    false,
                    "EUR",
                    "80.12",
                    true,
                    "GBR",
                    "100.24",
                    true
                ),
                listOf(
                    WalletApi(
                        0,
                        "Кошелек 1",
                        "3515",
                        "3516",
                        "353",
                        "2100",
                        "RUB",
                        100,
                        false
                    )
                )
            )
        )
    }

    override fun registrationUser(email: String): Single<Long> {
        TODO("Not yet implemented")
    }
}
