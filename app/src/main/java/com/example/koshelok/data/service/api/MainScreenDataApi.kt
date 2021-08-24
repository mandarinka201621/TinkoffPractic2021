package com.example.koshelok.data.service.api

import kotlinx.serialization.Serializable

@Serializable
data class MainScreenDataApi(
    val balanceApi: BalanceApi,
    val exchangeRatesApi: ExchangeRatesApi,
    val wallets: List<WalletApi>
)
