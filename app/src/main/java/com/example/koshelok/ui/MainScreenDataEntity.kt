package com.example.koshelok.ui

import com.example.koshelok.ui.listwallet.entity.BalanceEntity
import com.example.koshelok.ui.listwallet.entity.ExchangeRatesEntity
import com.example.koshelok.ui.listwallet.entity.WalletEntity

data class MainScreenDataEntity(
    val balanceEntity: BalanceEntity,
    val exchangeRatesEntity: ExchangeRatesEntity,
    val wallets: List<WalletEntity>
)
