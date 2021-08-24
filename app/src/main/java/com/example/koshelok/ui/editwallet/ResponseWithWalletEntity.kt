package com.example.koshelok.ui.editwallet

import com.example.koshelok.domain.Response

data class ResponseWithWalletEntity(
    val walletId: Long,
    val response: Response
)
