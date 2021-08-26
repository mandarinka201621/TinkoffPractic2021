package com.example.koshelok.data.mappers.exchangerates

import com.example.koshelok.data.db.entity.ExchangeRatesDb
import com.example.koshelok.data.service.api.ExchangeRatesApi
import javax.inject.Inject

class ExchangeRatesDbToApiMapper @Inject constructor() : (ExchangeRatesDb) -> ExchangeRatesApi {
    override fun invoke(exchangeRates: ExchangeRatesDb): ExchangeRatesApi {
        return ExchangeRatesApi(
            firstCurrency = exchangeRates.firstCurrency,
            firstCourse = exchangeRates.firstCourse,
            firstIsUp = exchangeRates.firstIsUp,
            secondCurrency = exchangeRates.secondCurrency,
            secondCourse = exchangeRates.secondCourse,
            secondIsUp = exchangeRates.secondIsUp,
            thirdCurrency = exchangeRates.thirdCurrency,
            thirdCourse = exchangeRates.thirdCourse,
            thirdIsUp = exchangeRates.thirdIsUp
        )
    }
}
