package com.example.koshelok.ui.listwallet.model


data class WalletModel(
    val id: Long,
    val name: String,
    val amountMoney: String,
    val currency: String,
    val isHide: Boolean
)
