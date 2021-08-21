package com.example.koshelok.ui.listwallet.entity

data class ExchangeRatesEntity(
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
