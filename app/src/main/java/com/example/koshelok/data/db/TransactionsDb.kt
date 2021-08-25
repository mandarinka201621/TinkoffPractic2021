package com.example.koshelok.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Transactions")
data class TransactionsDb(
    val money: String,
    val idCategory: Long,
    val type: Int,
    val operation: String,
    val idIcon: Int,
    val color: Int,
    val currency: String,
    val time: Long,
    val walletId: Long
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long? = null
}
