package com.example.koshelok.data.service.api

data class ReceiveTransactionApi(
    val id: Long,
    val money: String,
    val typeCategory: Boolean,
    val nameCategory: String,
    val color: Int,
    val currency: String,
    val time: Long
)
