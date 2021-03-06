package com.example.koshelok.data.mappers.wallets

import com.example.koshelok.data.service.api.WalletApi
import com.example.koshelok.domain.Currency
import com.example.koshelok.ui.listwallet.entity.WalletEntity
import javax.inject.Inject

class WalletApiToWalletEntityMapper @Inject constructor() : (WalletApi) -> WalletEntity {

    override operator fun invoke(walletApi: WalletApi) =
        WalletEntity(
            id = walletApi.id ?: 0,
            name = walletApi.name,
            amountMoney = walletApi.amountMoney,
            currency = Currency.valueOf(walletApi.currency),
            isHide = walletApi.isHide
        )
}
