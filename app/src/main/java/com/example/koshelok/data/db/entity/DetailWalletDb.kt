package com.example.koshelok.data.db.entity

import androidx.room.Embedded
import androidx.room.Relation

data class DetailWalletDb(
    @Embedded
    val walletDb: WalletDb,
    @Relation(
        parentColumn = "id",
        entityColumn = "walletId"
    )
    val transaction: List<TransactionDb>
)
