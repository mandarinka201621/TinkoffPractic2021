package com.example.koshelok.data.mappers

import com.example.koshelok.ui.listwallet.entity.BalanceEntity
import javax.inject.Inject

class BalanceApiToBalanceEntityMapper @Inject constructor() :
        (String, String, String) -> BalanceEntity {

    override operator fun invoke(balance: String, income: String, consumption: String) =
        BalanceEntity(
            amountMoney = balance,
            incomeMoney = income,
            consumptionMoney = consumption
        )
}
