package com.example.koshelok.data.mappers

import com.example.koshelok.data.db.entity.WalletDb
import com.example.koshelok.data.service.api.WalletApi
import javax.inject.Inject

class WalletDbToWalletApiMapper @Inject constructor() :
        (WalletDb) -> WalletApi {
    override fun invoke(walletDb: WalletDb): WalletApi {
        return WalletApi(
            id = walletDb.id,
            name = walletDb.name,
            amountMoney = walletDb.amountMoney,
            income = walletDb.income,
            consumption = walletDb.consumption,
            limit = walletDb.limit,
            currency = walletDb.currency,
            personId = walletDb.personId,
            isExceededLimit = walletDb.isExceededLimit,
            isHide = walletDb.isHide
        )
    }
}
