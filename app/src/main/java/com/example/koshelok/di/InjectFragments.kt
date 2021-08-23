package com.example.koshelok.di

import com.example.koshelok.ui.addoperation.AddOperationFragment
import com.example.koshelok.ui.categoryoperation.CategoryOperationFragment
import com.example.koshelok.ui.detailwallet.DetailWalletFragment
import com.example.koshelok.ui.listwallet.ListWalletFragment
import com.example.koshelok.ui.onboarding.OnBoardingScreenFragment
import com.example.koshelok.ui.sumoperation.SumOperationFragment
import com.example.koshelok.ui.typeoperation.TypeOperationFragment

interface InjectFragments {

    fun inject(onBoardingScreenFragment: OnBoardingScreenFragment)

    fun inject(addOperationFragment: AddOperationFragment)

    fun inject(detailWalletFragment: DetailWalletFragment)

    fun inject(sumOperationFragment: SumOperationFragment)

    fun inject(categoryOperationFragment: CategoryOperationFragment)

    fun inject(typeOperationFragment: TypeOperationFragment)

    fun inject(listWalletFragment: ListWalletFragment)
}
