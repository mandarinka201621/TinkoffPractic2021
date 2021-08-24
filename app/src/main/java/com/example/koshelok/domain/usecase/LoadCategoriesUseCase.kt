package com.example.koshelok.domain.usecase

import com.example.koshelok.domain.Category
import com.example.koshelok.domain.repository.LoadCategoriesRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

interface LoadCategoriesUseCase {
    operator fun invoke(personId: Long): Single<List<Category>>
}

class LoadCategoriesUseCaseImpl @Inject constructor(
    private val loadCategoriesRepository: LoadCategoriesRepository
) : LoadCategoriesUseCase {

    override fun invoke(personId: Long): Single<List<Category>> {
        return loadCategoriesRepository.getCategories(personId)
    }
}
