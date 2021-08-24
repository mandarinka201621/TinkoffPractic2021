package com.example.koshelok.data.service.api

import kotlinx.serialization.Serializable

@Serializable
data class WalletApi(
    val id: Long? = null,
    val name: String,
    val amountMoney: String,
    val income: String,
    val expense: String,
    val limit: String?,
    val currency: String,
    val personId: Long,
    val isHide: Boolean
)
