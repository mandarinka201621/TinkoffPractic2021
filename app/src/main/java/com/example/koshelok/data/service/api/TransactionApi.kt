package com.example.koshelok.data.service.api

import kotlinx.serialization.Serializable

@Serializable
data class TransactionApi(
    val id: Long,
    val money: String,
    val idCategory: Long,
    val type: Int,
    val operation: String,
    val idIcon: Int,
    val color: Int,
    val currency: String,
    val time: Long
)
