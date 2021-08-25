package com.example.koshelok.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Category(
    val id: Long,
    var type: TypeOperation,
    var operation: String,
    var iconId: Int,
    var color: Int
): Parcelable
