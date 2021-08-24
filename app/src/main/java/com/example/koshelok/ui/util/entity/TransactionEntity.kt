package com.example.koshelok.ui.util.entity

import android.os.Parcelable
import com.example.koshelok.domain.Currency
import com.example.koshelok.domain.TypeOperation
import kotlinx.parcelize.Parcelize

@Parcelize
data class TransactionEntity(
    val id: Long? = null,
    val idWallet: Long,
    var sum: String?,
    var type: TypeOperation?,
    var categoryEntity: CategoryEntity?,
    var date: Long?,
    val currency: Currency = Currency.RUB
) : Parcelable
