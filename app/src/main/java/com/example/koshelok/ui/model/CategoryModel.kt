package com.example.koshelok.ui.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CategoryModel(
    val icon: Int,
    val typeOperation: String,
    val color: Int,
    var isEnable: Boolean,
    val id: Int
) : Parcelable
