package com.example.koshelok.data.db

import com.example.koshelok.data.db.entity.WalletDb
import com.example.koshelok.data.mappers.WalletApiToWalletDbMapper
import com.example.koshelok.data.service.api.WalletApi
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

interface MainWalletSource {
    fun insertAllWallets(wallets: List<WalletApi>)

    fun getWallets(personId: Long): Single<List<WalletDb>>

    fun insertWallet(wallet: WalletApi)
}

class MainWalletSourceImpl @Inject constructor(
    private val database: KoshelokDatabase,
    private val walletMapper: WalletApiToWalletDbMapper
) : MainWalletSource {

    override fun insertAllWallets(wallets: List<WalletApi>) {
        database.getWalletsDao()
            .addWallets(wallets.map(walletMapper))
    }

    override fun getWallets(personId: Long): Single<List<WalletDb>> {
        return database.getWalletsDao()
            .getWalletByPersonId(personId)
    }

    override fun insertWallet(wallet: WalletApi) {
        database.getWalletsDao()
            .addWallet(walletMapper(wallet))
    }
}
