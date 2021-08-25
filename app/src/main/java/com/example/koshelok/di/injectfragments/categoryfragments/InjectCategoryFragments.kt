package com.example.koshelok.di.injectfragments.categoryfragments

import com.example.koshelok.ui.createcategory.CreateCategoryFragment
import com.example.koshelok.ui.typecategory.CreateTypeCategoryFragment

interface InjectCategoryFragments {

    fun inject(createCategoryFragment: CreateCategoryFragment)

    fun inject(createTypeCategoryFragment: CreateTypeCategoryFragment)
}
