package com.example.koshelok.ui.util.entity

import android.os.Parcelable
import com.example.koshelok.domain.Currency
import kotlinx.parcelize.Parcelize

@Parcelize
data class CreateWalletEntity(
    val id: Long? = null,
    var limit: String? = null,
    var name: String,
    var currency: Currency,
) : Parcelable
