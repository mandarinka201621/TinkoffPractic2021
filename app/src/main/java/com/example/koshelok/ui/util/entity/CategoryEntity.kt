package com.example.koshelok.ui.util.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CategoryEntity(
    var position: Int = DEFAULT_POSITION,
    val icon: Int,
    val typeOperation: String,
    val color: Int,
    var isEnable: Boolean,
    val id: Long
) : Parcelable {
    companion object {
        const val DEFAULT_POSITION = -1
    }
}
