package com.example.koshelok.ui.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CreateWalletEntity(
    val id: Long? = null,
    var limit: String? = null,
    var name: String,
    var currency: String,
) : Parcelable
