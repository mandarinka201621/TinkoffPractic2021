package com.example.koshelok.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.koshelok.data.db.entity.WalletDb
import io.reactivex.rxjava3.core.Maybe

@Dao
interface WalletsDao {

    @Query("SELECT * FROM wallets WHERE id = :walletId")
    fun getWalletByWalletId(walletId: Long): Maybe<WalletDb>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addWallet(wallet: WalletDb)
}
