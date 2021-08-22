package com.example.koshelok.ui.model

import android.os.Parcelable
import com.example.koshelok.domain.TypeOperation
import kotlinx.parcelize.Parcelize

@Parcelize
data class Transaction(
    val idWallet: Int,
    var sum: String?,
    var type: TypeOperation?,
    var categoryModel: CategoryModel?,
    var date: Long?
) : Parcelable
