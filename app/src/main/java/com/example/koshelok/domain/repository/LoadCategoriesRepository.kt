package com.example.koshelok.domain.repository

import com.example.koshelok.domain.Category
import io.reactivex.rxjava3.core.Single

interface LoadCategoriesRepository {

    fun getCategories(personId: Long, type: Int): Single<List<Category>>
}
