package com.example.koshelok.data.mappers

import com.example.koshelok.data.service.api.BalanceApi
import com.example.koshelok.ui.listwallet.entity.BalanceEntity
import javax.inject.Inject

class BalanceApiToBalanceEntityMapper @Inject constructor() : (BalanceApi) -> BalanceEntity {

    override operator fun invoke(balanceApi: BalanceApi) =
        BalanceEntity(
            amountMoney = balanceApi.amountMoney,
            incomeMoney = balanceApi.incomeMoney,
            consumptionMoney = balanceApi.consumptionMoney
        )
}
