package com.example.koshelok.data.db.entity

import androidx.room.Embedded
import androidx.room.Relation

data class MainScreenDataDb(
    @Embedded
    val balanceDb: BalanceDb,
    @Relation(
        parentColumn = "personId",
        entityColumn = "personId"
    )
    val exchangeRatesDb: ExchangeRatesDb,
    @Relation(
        parentColumn = "personId",
        entityColumn = "personId"
    )
    val wallets: List<WalletDb>
)
