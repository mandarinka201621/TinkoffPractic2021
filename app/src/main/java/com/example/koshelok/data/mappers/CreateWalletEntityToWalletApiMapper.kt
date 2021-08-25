package com.example.koshelok.data.mappers

import com.example.koshelok.data.service.api.WalletApi
import com.example.koshelok.ui.util.entity.CreateWalletEntity
import javax.inject.Inject

class CreateWalletEntityToWalletApiMapper @Inject constructor() :
        (Long?, Long, CreateWalletEntity) -> WalletApi {

    override operator fun invoke(
        id: Long?,
        personId: Long,
        createWalletEntity: CreateWalletEntity
    ): WalletApi =
        WalletApi(
            id = id,
            name = createWalletEntity.name,
            amountMoney = "0",
            income = "0",
            consumption = "0",
            limit = createWalletEntity.limit,
            currency = createWalletEntity.currency.name,
            personId = personId,
            isExceededLimit = false,
            isHide = false
        )
}
