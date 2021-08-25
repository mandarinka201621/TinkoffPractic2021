package com.example.koshelok.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

@Dao
interface WalletsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addWallets(wallets: List<WalletDb>): Completable

    @Query("SELECT * FROM wallets WHERE id = :walletId")
    fun getWalletByWalletId(walletId: Long): Single<WalletDb>

    @Query("SELECT * FROM wallets WHERE personId =:personId")
    fun getWalletByPersonId(personId: Long): Single<WalletDb>

}
