package com.example.koshelok.di

import com.example.koshelok.ui.categories.categoryoperation.CategoryOperationFragment
import com.example.koshelok.ui.categories.createcategory.CreateCategoryFragment
import com.example.koshelok.ui.detailwallet.DetailWalletFragment
import com.example.koshelok.ui.listwallet.ListWalletFragment
import com.example.koshelok.ui.onboarding.OnBoardingScreenFragment
import com.example.koshelok.ui.transactions.addoperation.AddOperationFragment
import com.example.koshelok.ui.transactions.sumoperation.SumOperationFragment
import com.example.koshelok.ui.transactions.typecategory.CreateTypeCategoryFragment
import com.example.koshelok.ui.transactions.typeoperation.TypeOperationFragment
import com.example.koshelok.ui.wallet.editwallet.EditWalletFragment

interface InjectFragments {

    fun inject(onBoardingScreenFragment: OnBoardingScreenFragment)

    fun inject(addOperationFragment: AddOperationFragment)

    fun inject(detailWalletFragment: DetailWalletFragment)

    fun inject(sumOperationFragment: SumOperationFragment)

    fun inject(categoryOperationFragment: CategoryOperationFragment)

    fun inject(typeOperationFragment: TypeOperationFragment)

    fun inject(listWalletFragment: ListWalletFragment)

    fun inject(editWalletFragment: EditWalletFragment)

    fun inject(createCategoryFragment: CreateCategoryFragment)

    fun inject(createTypeCategoryFragment: CreateTypeCategoryFragment)
}
