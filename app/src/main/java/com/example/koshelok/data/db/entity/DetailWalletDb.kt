package com.example.koshelok.data.db.entity

import androidx.room.Embedded
import androidx.room.Relation


data class DetailWalletDb(
    @Embedded
    val wallet: WalletDb,
    @Relation(
        parentColumn = "id",
        entityColumn = "walletId"
    )
    val transactions: List<TransactionDb>
)
