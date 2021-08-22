package com.example.koshelok.di

import com.example.koshelok.ui.addoperation.AddOperationFragment
import com.example.koshelok.ui.categoryoperation.CategoryOperationFragment
import com.example.koshelok.ui.detailwallet.DetailWalletFragment
import com.example.koshelok.ui.listwallet.WalletListFragment
import com.example.koshelok.ui.onboarding.OnBoardingScreenFragment
import com.example.koshelok.ui.sumoperation.SumOperationFragment
import com.example.koshelok.ui.typeoperation.TypeOperationFragment

interface InjectFragments {

    fun injectOnBoardFragment(onBoardingScreenFragment: OnBoardingScreenFragment)

    fun injectAddOperationFragment(addOperationFragment: AddOperationFragment)

    fun injectDetailWalletFragment(detailWalletFragment: DetailWalletFragment)

    fun injectSumOperationFragment(sumOperationFragment: SumOperationFragment)

    fun injectCategoryOperationFragment(categoryOperationFragment: CategoryOperationFragment)

    fun injectTypeOperationFragment(typeOperationFragment: TypeOperationFragment)

    fun injectWalletsList(walletListFragment: WalletListFragment)
}
