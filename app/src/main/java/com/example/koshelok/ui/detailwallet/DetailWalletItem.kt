package com.example.koshelok.ui.detailwallet

import com.example.koshelok.domain.Category

sealed class DetailWalletItem {
    data class HeaderDetailWallet(
        val id: Int = 0,
        val amountMoney: Int,
        val income: Int,
        val consumption: Int,
        val limit: Int
    ) : DetailWalletItem()

    data class Day(val day: String) : DetailWalletItem()

    data class Transaction(
        val category: Category,
        val money: Int,
        val time: String,
        val day: String
    ) :
        DetailWalletItem()
}
