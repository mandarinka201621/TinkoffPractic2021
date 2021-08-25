package com.example.koshelok.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.koshelok.data.db.dao.TransactionDao
import com.example.koshelok.data.db.dao.WalletsDao
import com.example.koshelok.data.db.entity.TransactionsDb
import com.example.koshelok.data.db.entity.WalletDb

@Database(version = 1, entities = [TransactionsDb::class, WalletDb::class], exportSchema = false)
abstract class KoshelokDatabase : RoomDatabase() {

    abstract fun getWalletsDao(): WalletsDao

    abstract fun getTransactionDao(): TransactionDao
}
