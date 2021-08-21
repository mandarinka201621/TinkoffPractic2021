package com.example.koshelok.ui.listwallet.entity


data class WalletEntity(
    val id: Long,
    val name: String,
    val amountMoney: String,
    val currency: String,
    val isHide: Boolean
)
