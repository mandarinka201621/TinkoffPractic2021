package com.example.koshelok.data.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(version = 1, entities = [TransactionsDb::class, WalletDb::class], exportSchema = false)
abstract class KoshelokDatabase : RoomDatabase() {

    abstract fun getWalletsDao(): WalletsDao

    abstract fun getTransactionDao(): TransactionDao
}
