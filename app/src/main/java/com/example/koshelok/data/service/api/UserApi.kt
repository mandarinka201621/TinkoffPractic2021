package com.example.koshelok.data.service.api

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserApi(
    @SerialName("personId")
    val id: Int? = null,
    val email: String
)
