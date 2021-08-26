package com.example.koshelok.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.koshelok.data.db.entity.BalanceDb
import com.example.koshelok.data.db.entity.ExchangeRatesDb
import com.example.koshelok.data.db.entity.MainScreenDataDb
import com.example.koshelok.data.db.entity.WalletDb
import io.reactivex.rxjava3.core.Maybe

@Dao
interface MainScreenDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addWallets(wallets: List<WalletDb>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertBalance(balanceDb: BalanceDb)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertExchangeRates(exchangeRatesDb: ExchangeRatesDb)

    @Transaction
    fun insertMainScreenData(
        balanceDb: BalanceDb,
        exchangeRatesDb: ExchangeRatesDb,
        wallets: List<WalletDb>
    ) {
        insertBalance(balanceDb)
        insertExchangeRates(exchangeRatesDb)
        addWallets(wallets)
    }

    @Transaction
    @Query("SELECT * FROM Balance WHERE personId= :personId")
    fun getMainScreenData(personId: Long): Maybe<MainScreenDataDb>
}
