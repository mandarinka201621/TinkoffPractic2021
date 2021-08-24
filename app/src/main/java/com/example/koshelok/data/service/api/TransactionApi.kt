package com.example.koshelok.data.service.api

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TransactionApi(
    @SerialName("transactionId")
    val id: Long,
    @SerialName("value")
    val money: String,
    @SerialName("categoryId")
    val idCategory: Long,
    @SerialName("category")
    val type: Int,
    @SerialName("categoryName")
    val operation: String,
    @SerialName("icon")
    val idIcon: Int,
    @SerialName("colour")
    val color: Int,
    val currency: String,
    val time: Long
)
