package com.example.koshelok.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.koshelok.data.db.entity.DetailWalletDb
import com.example.koshelok.data.db.entity.TransactionsDb
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

@Dao
interface TransactionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllTransactions(transactions: List<TransactionsDb>): Completable

    @Transaction
    @Query("SELECT * FROM Wallets WHERE id=:walletId")
    fun getDetailWallet(walletId: Long): Single<DetailWalletDb>
}
