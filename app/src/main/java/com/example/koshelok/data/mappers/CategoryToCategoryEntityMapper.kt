package com.example.koshelok.data.mappers

import com.example.koshelok.domain.Category
import com.example.koshelok.ui.entity.CategoryEntity
import javax.inject.Inject

class CategoryToCategoryEntityMapper @Inject constructor() : (Category) -> CategoryEntity {

    override fun invoke(category: Category): CategoryEntity {
        return CategoryEntity(
            id = category.id,
            icon = category.iconId,
            typeOperation = category.operation,
            color = category.color,
            isEnable = false,
        )
    }
}
