package com.example.koshelok.data.mappers

import com.example.koshelok.data.db.entity.WalletDb
import com.example.koshelok.data.service.api.WalletApi
import javax.inject.Inject

class WalletApiToWalletDbMapper @Inject constructor() : (WalletApi) -> WalletDb {


    override fun invoke(wallet: WalletApi): WalletDb {
        return WalletDb(
            id = wallet.id ?: 0,
            name = wallet.name,
            amountMoney = wallet.amountMoney,
            income = wallet.income,
            consumption = wallet.consumption,
            limit = wallet.limit,
            currency = wallet.currency,
            personId = wallet.personId,
            isExceededLimit = wallet.isExceededLimit,
            isHide = wallet.isHide
        )
    }
}
