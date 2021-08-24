package com.example.koshelok.data.mappers

import com.example.koshelok.data.IconConverter
import com.example.koshelok.data.service.api.CategoryApi
import com.example.koshelok.domain.Category
import javax.inject.Inject

class CategoryApiToCategoryMapper @Inject constructor(
    private val intToTypeCategoryMapper: IntToTypeCategoryMapper,
    private val iconConverter: IconConverter
) : (CategoryApi) -> Category {
    override operator fun invoke(categoryApi: CategoryApi) =
        Category(
            id = categoryApi.id,
            type = intToTypeCategoryMapper(categoryApi.type),
            operation = categoryApi.operation,
            iconId = iconConverter.convertNumberToDrawableId(categoryApi.idIcon),
            color = categoryApi.color
        )
}
