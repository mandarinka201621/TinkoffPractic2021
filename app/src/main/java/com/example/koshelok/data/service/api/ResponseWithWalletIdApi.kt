package com.example.koshelok.data.service.api

import kotlinx.serialization.Serializable

@Serializable
data class ResponseWithWalletIdApi(
    val walletId: Long,
    val code: Int
)
