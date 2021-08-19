package com.example.koshelok.domain

import android.graphics.Color

sealed class Category {

    abstract val icon: Int
    abstract val typeOperation: String
    abstract val color: Int
    private companion object{
        const val GREEN_COLOR = "#00B92D"
        const val BLUE_COLOR = "#5833EE"
    }

    data class Income(
        override val typeOperation: String,
        override val icon: Int,
        override val color: Int = Color.parseColor(GREEN_COLOR)
    ) : Category()

    data class Consumption(
        override val typeOperation: String,
        override val icon: Int,
        override val color: Int = Color.parseColor(BLUE_COLOR)
    ): Category()
}
