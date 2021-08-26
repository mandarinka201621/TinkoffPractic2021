package com.example.koshelok.data.repository

import com.example.koshelok.data.mappers.category.CategoryApiToCategoryMapper
import com.example.koshelok.data.service.AppService
import com.example.koshelok.domain.Category
import com.example.koshelok.domain.repository.LoadCategoriesRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class LoadCategoriesRepositoryImpl @Inject constructor(
    private val appService: AppService,
    private val categoryMapper: CategoryApiToCategoryMapper
) : LoadCategoriesRepository {

    override fun getCategories(personId: Long, type: Int): Single<List<Category>> {
        return appService.getCategories(personId, type)
            .map { categories ->
                categories.map(categoryMapper)
            }
    }
}
