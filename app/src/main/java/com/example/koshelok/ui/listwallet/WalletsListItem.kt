package com.example.koshelok.ui.listwallet

sealed class WalletsListItem{
    data class Wallet(
        val id: Long,
        val name: String,
        val amountMoney: String,
        val currency: String,
        val isHide: Boolean
    ):WalletsListItem()

    data class ExchangeRates(
        val firstCurrency: String,
        val firstCourse: String,
        val firstIsUp: Boolean,
        val secondCurrency: String,
        val secondCourse: String,
        val secondIsUp: Boolean,
        val thirdCurrency: String,
        val thirdCourse: String,
        val thirdIsUp: Boolean
    ):WalletsListItem()
}
