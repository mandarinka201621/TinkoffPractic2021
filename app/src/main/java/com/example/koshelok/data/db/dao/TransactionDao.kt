package com.example.koshelok.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.koshelok.data.db.entity.TransactionDb
import io.reactivex.rxjava3.core.Maybe

@Dao
interface TransactionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllTransactions(transactions: List<TransactionDb>)

    @Query("SELECT * FROM Transactions WHERE walletId= :id")
    fun getTransactionsByWalletId(id: Long): Maybe<List<TransactionDb>>

    @Query("DELETE FROM Transactions WHERE id=:transactionId")
    fun deleteTransactions(transactionId: Long)
}
