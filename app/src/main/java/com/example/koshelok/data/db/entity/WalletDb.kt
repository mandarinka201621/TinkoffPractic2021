package com.example.koshelok.data.db.entity

import androidx.room.Entity

@Entity(tableName = "Wallets")
data class WalletDb(
    var id: Long,
    val name: String,
    val amountMoney: String,
    val income: String,
    val consumption: String,
    val limit: String?,
    val currency: String,
    val personId: Long,
    val isHide: Boolean
)
