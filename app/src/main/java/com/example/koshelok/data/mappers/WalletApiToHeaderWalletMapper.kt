package com.example.koshelok.data.mappers

import com.example.koshelok.data.service.api.WalletApi
import com.example.koshelok.domain.Currency
import com.example.koshelok.ui.detailwallet.DetailWalletItem
import javax.inject.Inject

class WalletApiToHeaderWalletMapper @Inject constructor() :
        (WalletApi) -> DetailWalletItem.HeaderDetailWallet {

    override operator fun invoke(walletApi: WalletApi) =
        DetailWalletItem.HeaderDetailWallet(
            nameWallet = walletApi.name,
            amountMoney = walletApi.amountMoney,
            income = walletApi.income,
            consumption = walletApi.expense,
            limit = walletApi.limit,
            currency = Currency.valueOf(walletApi.currency)
        )
}
