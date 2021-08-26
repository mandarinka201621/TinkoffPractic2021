package com.example.koshelok.data.service.api

import kotlinx.serialization.Serializable

@Serializable
data class DetailWalletApi(
    val walletApi: WalletApi,
    val transactions: List<TransactionApi>
)
