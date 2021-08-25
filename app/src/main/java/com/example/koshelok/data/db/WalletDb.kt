package com.example.koshelok.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Wallets")
data class WalletDb(
    val name: String,
    val amountMoney: String,
    val income: String,
    val consumption: String,
    val limit: String?,
    val currency: String,
    val personId: Long,
    val isHide: Boolean
) {

    @PrimaryKey(autoGenerate = true)
    var id: Long? = null
}
