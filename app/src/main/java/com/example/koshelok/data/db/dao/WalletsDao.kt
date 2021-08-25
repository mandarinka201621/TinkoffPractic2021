package com.example.koshelok.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.koshelok.data.db.entity.WalletDb
import io.reactivex.rxjava3.core.Single

@Dao
interface WalletsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addWallets(wallets: List<WalletDb>)

    @Query("SELECT * FROM wallets WHERE id = :walletId")
    fun getWalletByWalletId(walletId: Long): Single<WalletDb>

    @Insert
    fun addWallet(wallet: WalletDb)

    @Query("SELECT * FROM wallets WHERE personId =:personId")
    fun getWalletByPersonId(personId: Long): Single<List<WalletDb>>

}
