package com.example.koshelok.data.mapper

import com.example.koshelok.data.service.api.BalanceApi
import com.example.koshelok.ui.listwallet.entity.BalanceEntity
import javax.inject.Inject

class BalanceApiToBalanceEntityMapper @Inject constructor() {

    operator fun invoke(balanceApi: BalanceApi) =
        BalanceEntity(
            amountMoney = balanceApi.amountMoney,
            incomeMoney = balanceApi.incomeMoney,
            consumptionMoney = balanceApi.consumptionMoney
        )
}
