package com.example.koshelok.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Balance")
data class BalanceDb(
    @PrimaryKey
    val personId: Long,
    @ColumnInfo(name = "amount_money")
    val amountMoney: String,
    val income: String,
    val consumption: String
)
