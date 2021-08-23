package com.example.koshelok.data.mappers

import com.example.koshelok.data.IconConverter
import com.example.koshelok.data.service.api.CategoryApi
import com.example.koshelok.domain.Category
import javax.inject.Inject

class CategoryToCategoryApiMapper @Inject constructor(
    private val iconConverter: IconConverter
) {

    operator fun invoke(category: Category) =
        CategoryApi(
            id = category.id,
            type = category.type.code,
            operation = category.operation,
            idIcon = iconConverter.convertDrawableIdToNumber(category.iconId),
            color = category.color
        )
}
