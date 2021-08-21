package com.example.koshelok.ui.model

import android.os.Parcelable
import com.example.koshelok.ui.typeoperation.TypeOperationViewModel
import kotlinx.parcelize.Parcelize

@Parcelize
data class Transaction(
    val idWallet: Int,
    var sum: String?,
    var type: TypeOperationViewModel.Select?,
    var categoryModel: CategoryModel?,
    var date: Long?
) : Parcelable
