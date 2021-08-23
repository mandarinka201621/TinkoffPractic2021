package com.example.koshelok.domain.repository

import com.example.koshelok.ui.listwallet.entity.BalanceEntity
import com.example.koshelok.ui.listwallet.entity.ExchangeRatesEntity
import com.example.koshelok.ui.listwallet.entity.WalletEntity
import io.reactivex.rxjava3.core.Single

interface ListWalletRepository {

    fun getExchangeRates(): Single<ExchangeRatesEntity>

    fun getBalance(): Single<BalanceEntity>

    fun getListWallet(): Single<List<WalletEntity>>
}