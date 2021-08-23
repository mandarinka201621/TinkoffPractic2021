package com.example.koshelok.data.mapper

import com.example.koshelok.domain.TypeOperation
import javax.inject.Inject

class IntToTypeCategoryMapper @Inject constructor() {
    operator fun invoke(type: Int): TypeOperation {
        return when (type) {
            0 -> TypeOperation.SELECT_EXPENSE
            1 -> TypeOperation.SELECT_INCOME
            else -> throw NullPointerException("error type")
        }
    }
}
