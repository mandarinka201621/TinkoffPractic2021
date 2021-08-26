package com.example.koshelok.data.mappers.category

import com.example.koshelok.data.service.api.CategoryApi
import com.example.koshelok.domain.Category
import com.example.koshelok.ui.util.IconConverter
import javax.inject.Inject

class CategoryToCategoryApiMapper @Inject constructor(
    private val iconConverter: IconConverter
) : (Long, Category) -> CategoryApi {

    override operator fun invoke(personId: Long, category: Category) =
        CategoryApi(
            id = category.id,
            type = category.type.code,
            operation = category.operation,
            idIcon = iconConverter.convertDrawableIdToNumber(category.iconId),
            color = category.color,
            personId = personId
        )
}
