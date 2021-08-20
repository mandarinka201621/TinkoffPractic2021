package com.example.koshelok.ui.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CategoryModel(
    val icon: Int,
    val typeOperation: String,
    val color: Int,
    val enable: Boolean,
    var id: Int = UNDEFINED_ID
) : Parcelable {
    companion object {
        const val UNDEFINED_ID = -1
    }
}
