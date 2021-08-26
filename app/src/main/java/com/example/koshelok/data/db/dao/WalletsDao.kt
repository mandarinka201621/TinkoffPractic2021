package com.example.koshelok.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.koshelok.data.db.entity.DetailWalletDb
import com.example.koshelok.data.db.entity.WalletDb
import io.reactivex.rxjava3.core.Maybe

@Dao
interface WalletsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addWallet(wallet: WalletDb)


    @Query("SELECT * FROM Wallets WHERE id=:walletId")
    fun getDetailWalletDb(walletId: Long): Maybe<DetailWalletDb>

}
