package com.example.koshelok.data.service.api

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WalletApi(
    @SerialName("walletId")
    val id: Long? = null,
    val name: String,
    val amountMoney: String,
    val income: String,
    val consumption: String,
    val limit: String?,
    val currency: String,
    val personId: Long,
    val isHide: Boolean
)
