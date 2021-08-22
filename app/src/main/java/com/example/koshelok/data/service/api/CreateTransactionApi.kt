package com.example.koshelok.data.service.api

import kotlinx.serialization.Serializable

@Serializable
data class CreateTransactionApi (
    val idWallet: Long,
    val money: String,
    val idCategory: Long,
    val currency: String,
    val time: Long
)
