package com.example.koshelok.data.service.api

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CategoryApi (
    @SerialName("categoryId")
    val id: Long,
    @SerialName("value")
    val type: Int,
    @SerialName("name")
    val operation: String,
    @SerialName("icon")
    val idIcon: Int,
    @SerialName("colour")
    val color: Int,
    val personId: Long
)
