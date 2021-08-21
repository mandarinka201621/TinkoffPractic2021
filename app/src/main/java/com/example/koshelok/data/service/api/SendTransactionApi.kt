package com.example.koshelok.data.service.api

data class SendTransactionApi (
    val idWallet: Long,
    val money: String,
    val idCategory: Long,
    val currency: String,
    val time: Long
)
