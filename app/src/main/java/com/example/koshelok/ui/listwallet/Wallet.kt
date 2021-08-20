package com.example.koshelok.ui.listwallet

data class Wallet(
    val id: Long,
    val name: String,
    val amountMoney: String,
    val currency: String,
    val isHide: Boolean
)
