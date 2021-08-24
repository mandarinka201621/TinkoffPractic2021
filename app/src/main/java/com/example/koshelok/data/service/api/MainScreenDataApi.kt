package com.example.koshelok.data.service.api

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MainScreenDataApi(
    @SerialName("balance")
    val balance: String,
    @SerialName("income")
    val income: String,
    @SerialName("consumption")
    val consumption: String,
    @SerialName("currencyDto")
    val exchangeRatesApi: ExchangeRatesApi,
    @SerialName("wallets")
    val wallets: List<WalletApi>
)
