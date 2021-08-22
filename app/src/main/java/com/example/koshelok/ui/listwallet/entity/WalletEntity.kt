package com.example.koshelok.ui.listwallet.entity

import com.example.koshelok.domain.Currency


data class WalletEntity(
    val id: Long,
    val name: String,
    val amountMoney: String,
    val currency: Currency,
    val isHide: Boolean
)
