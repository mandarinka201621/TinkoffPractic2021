package com.example.koshelok.data.service.api

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CreateTransactionApi (
    @SerialName("transactionId")
    val id: Long?,
    @SerialName("walletId")
    val idWallet: Long,
    @SerialName("value")
    val money: String,
    @SerialName("categoryId")
    val idCategory: Long,
    val currency: String,
    val time: Long
)
