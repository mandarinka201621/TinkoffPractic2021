package com.example.koshelok.ui.model

import android.os.Parcelable
import com.example.koshelok.domain.Currency
import com.example.koshelok.domain.TypeOperation
import kotlinx.parcelize.Parcelize

@Parcelize
data class Transaction(
    val idWallet: Long,
    var sum: String?,
    var type: TypeOperation?,
    var categoryModel: CategoryModel?,
    var date: Long?,
    val currency: Currency = Currency.RUB
) : Parcelable
