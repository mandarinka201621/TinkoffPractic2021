package com.example.koshelok.data.db.source

import com.example.koshelok.data.db.KoshelokDatabase
import com.example.koshelok.data.mappers.wallets.WalletApiToWalletDbMapper
import com.example.koshelok.data.service.api.WalletApi
import javax.inject.Inject

interface WalletSource {

    fun insertWallet(wallet: WalletApi)

    fun deleteWallet(walletId: Long)
}

class WalletSourceImpl @Inject constructor(
    private val database: KoshelokDatabase,
    private val walletMapper: WalletApiToWalletDbMapper
) : WalletSource {

    override fun insertWallet(wallet: WalletApi) {
        database.getWalletsDao()
            .addWallet(walletMapper(wallet))
    }

    override fun deleteWallet(walletId: Long) {
        return database.getWalletsDao().deleteWallet(walletId)
    }
}
