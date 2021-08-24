package com.example.koshelok.data.mappers

import com.example.koshelok.data.service.api.WalletApi
import com.example.koshelok.ui.entity.CreateWalletEntity
import javax.inject.Inject

class CreateWalletEntityToWalletApi @Inject constructor() :
        (Long, CreateWalletEntity) -> WalletApi {

    override operator fun invoke(personId: Long, createWalletEntity: CreateWalletEntity) =
        WalletApi(
            name = createWalletEntity.name,
            amountMoney = "0",
            income = "0",
            consumption = "0",
            limit = createWalletEntity.limit,
            currency = createWalletEntity.currency.name,
            personId = personId,
            isHide = false
        )
}
