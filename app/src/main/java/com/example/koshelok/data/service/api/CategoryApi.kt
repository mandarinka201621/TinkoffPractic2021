package com.example.koshelok.data.service.api

import kotlinx.serialization.Serializable

@Serializable
data class CategoryApi (
    val id: Long,
    val type: Int,
    val operation: String,
    val idIcon: Int,
    val color: Int
)
