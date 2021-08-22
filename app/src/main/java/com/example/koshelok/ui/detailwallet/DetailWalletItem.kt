package com.example.koshelok.ui.detailwallet

import com.example.koshelok.domain.Category

sealed class DetailWalletItem {
    data class HeaderDetailWallet(
        val nameWallet: String,
        val amountMoney: String,
        val income: String,
        val consumption: String,
        val limit: String,
        val currency: String
    ) : DetailWalletItem()

    data class Day(val day: String) : DetailWalletItem()

    data class Transaction(
        val id: Long,
        val category: Category,
        val money: String,
        val time: String,
        val day: String,
        val currency: String
    ) :
        DetailWalletItem()
}
