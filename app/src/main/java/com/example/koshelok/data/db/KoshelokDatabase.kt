package com.example.koshelok.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.koshelok.data.db.dao.MainScreenDao
import com.example.koshelok.data.db.dao.TransactionDao
import com.example.koshelok.data.db.dao.WalletsDao
import com.example.koshelok.data.db.entity.BalanceDb
import com.example.koshelok.data.db.entity.ExchangeRatesDb
import com.example.koshelok.data.db.entity.TransactionDb
import com.example.koshelok.data.db.entity.WalletDb

@Database(
    version = 1,
    entities = [TransactionDb::class, WalletDb::class, BalanceDb::class, ExchangeRatesDb::class],
    exportSchema = false
)
abstract class KoshelokDatabase : RoomDatabase() {

    abstract fun getWalletsDao(): WalletsDao

    abstract fun getTransactionDao(): TransactionDao

    abstract fun getMainScreenDao(): MainScreenDao
}
