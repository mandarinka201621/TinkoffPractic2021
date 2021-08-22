package com.example.koshelok.domain

import com.example.koshelok.ui.typeoperation.TypeOperationViewModel

data class Category(
    val id: Long,
    val type: TypeOperationViewModel.Select,
    val operation: String,
    val iconId: Int,
    val color: Int
)
