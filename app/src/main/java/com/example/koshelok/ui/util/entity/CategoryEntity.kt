package com.example.koshelok.ui.util.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CategoryEntity(
    val icon: Int,
    val typeOperation: String,
    val color: Int,
    var isEnable: Boolean,
    val id: Long
):Parcelable
