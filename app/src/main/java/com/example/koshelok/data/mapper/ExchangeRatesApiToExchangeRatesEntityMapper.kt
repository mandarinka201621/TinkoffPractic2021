package com.example.koshelok.data.mapper

import com.example.koshelok.data.service.api.ExchangeRatesApi
import com.example.koshelok.domain.Currency
import com.example.koshelok.ui.listwallet.entity.ExchangeRatesEntity
import javax.inject.Inject

class ExchangeRatesApiToExchangeRatesEntityMapper @Inject constructor() {

    operator fun invoke(exchangeRatesApi: ExchangeRatesApi) =
        ExchangeRatesEntity(
            firstCurrency = Currency.valueOf(exchangeRatesApi.firstCurrency),
            firstCourse = exchangeRatesApi.firstCourse,
            firstIsUp = exchangeRatesApi.firstIsUp,
            secondCurrency = Currency.valueOf(exchangeRatesApi.secondCurrency),
            secondCourse = exchangeRatesApi.secondCourse,
            secondIsUp = exchangeRatesApi.secondIsUp,
            thirdCurrency = Currency.valueOf(exchangeRatesApi.thirdCurrency),
            thirdCourse = exchangeRatesApi.thirdCourse,
            thirdIsUp = exchangeRatesApi.thirdIsUp
        )
}
