package com.example.koshelok.data.service.api

import kotlinx.serialization.Serializable

@Serializable
data class ExchangeRatesApi(
    val firstCurrency: String,
    val firstCourse: String,
    val firstIsUp: Boolean,
    val secondCurrency: String,
    val secondCourse: String,
    val secondIsUp: Boolean,
    val thirdCurrency: String,
    val thirdCourse: String,
    val thirdIsUp: Boolean
)
