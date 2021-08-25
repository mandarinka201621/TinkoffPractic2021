package com.example.koshelok.data.db

import com.example.koshelok.data.mappers.WalletApiToWalletDbMapper
import com.example.koshelok.data.service.api.WalletApi
import javax.inject.Inject

interface WalletSource {
    fun insertAllWallets(wallets: List<WalletApi>)

    fun insertWallet(wallet: WalletApi)
}

class WalletSourceImpl @Inject constructor(
    private val database: KoshelokDatabase,
    private val walletMapper: WalletApiToWalletDbMapper
) : WalletSource {
    override fun insertAllWallets(wallets: List<WalletApi>) {
        database.getWalletsDao()
            .addWallets(wallets.map(walletMapper))
    }

    override fun insertWallet(wallet: WalletApi) {
        database.getWalletsDao()
            .addWallet(walletMapper(wallet))
    }
}
