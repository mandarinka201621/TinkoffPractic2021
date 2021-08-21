package com.example.koshelok.data.service.api

data class WalletApi(
    val id: Long,
    val name: String,
    val amountMoney: String,
    val income: String,
    val expense: String,
    val limit: String,
    val currency: String,
    val isHide: Boolean
)
