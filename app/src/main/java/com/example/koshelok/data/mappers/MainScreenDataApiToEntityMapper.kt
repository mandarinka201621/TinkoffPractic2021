package com.example.koshelok.data.mappers

import com.example.koshelok.data.service.api.MainScreenDataApi
import com.example.koshelok.ui.listwallet.entity.MainScreenDataEntity
import javax.inject.Inject

class MainScreenDataApiToEntityMapper @Inject constructor(
    private val balanceMapper: BalanceApiToBalanceEntityMapper,
    private val exchangeRatesMapper: ExchangeRatesApiToExchangeRatesEntityMapper,
    private val walletMapper: WalletApiToWalletEntityMapper
) : (MainScreenDataApi) -> MainScreenDataEntity {

    override operator fun invoke(mainScreenDataApi: MainScreenDataApi) =
        MainScreenDataEntity(
            balanceMapper(mainScreenDataApi.balanceApi),
            exchangeRatesMapper(mainScreenDataApi.exchangeRatesApi),
            mainScreenDataApi.wallets.map {
                walletMapper(it)
            }
        )
}
