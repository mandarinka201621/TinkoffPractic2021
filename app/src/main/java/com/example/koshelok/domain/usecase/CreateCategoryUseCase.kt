package com.example.koshelok.domain.usecase

import com.example.koshelok.domain.Category
import com.example.koshelok.domain.repository.CreateCategoryRepository
import io.reactivex.rxjava3.core.Completable
import javax.inject.Inject

interface CreateCategoryUseCase {

    operator fun invoke(personId: Long, category: Category): Completable
}

class CreateCategoryUseCaseImpl @Inject constructor(
    private val createCategoryRepository: CreateCategoryRepository
) : CreateCategoryUseCase {

    override fun invoke(personId: Long, category: Category): Completable {
        return createCategoryRepository.createCategory(personId, category)
    }
}
