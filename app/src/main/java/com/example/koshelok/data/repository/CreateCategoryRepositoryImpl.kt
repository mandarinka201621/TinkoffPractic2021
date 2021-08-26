package com.example.koshelok.data.repository

import com.example.koshelok.data.mappers.category.CategoryToCategoryApiMapper
import com.example.koshelok.data.service.AppService
import com.example.koshelok.domain.Category
import com.example.koshelok.domain.repository.CreateCategoryRepository
import io.reactivex.rxjava3.core.Completable
import javax.inject.Inject

class CreateCategoryRepositoryImpl @Inject constructor(
    private val appService: AppService,
    private val categoryMapper: CategoryToCategoryApiMapper
) : CreateCategoryRepository {

    override fun createCategory(personId: Long, category: Category): Completable {
        return appService.createCategory(
            categoryMapper(personId, category)
        )
    }
}
