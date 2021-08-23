package com.example.koshelok.domain

data class Category(
    val id: Long,
    val type: TypeOperation,
    val operation: String,
    val iconId: Int,
    val color: Int
)
