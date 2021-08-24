package com.example.koshelok.domain.repository

import com.example.koshelok.domain.Category
import io.reactivex.rxjava3.core.Completable

interface CreateCategoryRepository {

    fun createCategory(personId: Long, category: Category): Completable
}
