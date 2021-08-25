package com.example.koshelok.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Transactions")
data class TransactionsDb(
    @PrimaryKey
    var id: Long,
    val money: String,
    val idCategory: Long,
    val type: Int,
    val operation: String,
    val idIcon: Int,
    val color: Int,
    val currency: String,
    val time: Long,
    val walletId: Long
)
