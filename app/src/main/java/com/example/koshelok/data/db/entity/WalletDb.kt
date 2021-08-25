package com.example.koshelok.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Wallets")
data class WalletDb(
    @PrimaryKey
    var id: Long,
    val name: String,
    val amountMoney: String,
    val income: String,
    val consumption: String,
    val limit: String?,
    val currency: String,
    val personId: Long,
    val isExceededLimit: Boolean,
    val isHide: Boolean
)
