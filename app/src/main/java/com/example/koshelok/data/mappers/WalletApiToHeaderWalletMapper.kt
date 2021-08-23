package com.example.koshelok.data.mappers

import com.example.koshelok.data.service.api.WalletApi
import com.example.koshelok.ui.detailwallet.DetailWalletItem
import javax.inject.Inject

class WalletApiToHeaderWalletMapper @Inject constructor() {

    operator fun invoke(walletApi: WalletApi) =
        DetailWalletItem.HeaderDetailWallet(
            nameWallet = walletApi.name,
            amountMoney = walletApi.amountMoney,
            income = walletApi.income,
            consumption = walletApi.expense,
            limit = walletApi.limit,
            currency = walletApi.currency
        )
}
