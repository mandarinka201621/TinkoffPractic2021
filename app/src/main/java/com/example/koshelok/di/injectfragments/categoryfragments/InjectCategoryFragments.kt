package com.example.koshelok.di.injectfragments.categoryfragments

import com.example.koshelok.ui.categories.createcategory.CreateCategoryFragment
import com.example.koshelok.ui.transactions.typecategory.CreateTypeCategoryFragment

interface InjectCategoryFragments {

    fun inject(createCategoryFragment: CreateCategoryFragment)

    fun inject(createTypeCategoryFragment: CreateTypeCategoryFragment)
}
