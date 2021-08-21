package com.example.koshelok.di.component

import com.example.koshelok.di.FragmentScope
import com.example.koshelok.ui.addoperation.AddOperationFragment
import com.example.koshelok.ui.detailwallet.DetailWalletFragment
import com.example.koshelok.ui.sumoperation.SumOperationFragment
import com.example.koshelok.ui.typeoperation.TypeOperationFragment
import dagger.Component

@FragmentScope
@Component(dependencies = [AppComponent::class])
interface TransactionComponent {
    fun injectAddOperationFragment(addOperationFragment: AddOperationFragment)

    fun injectDetailWalletFragment(detailWalletFragment: DetailWalletFragment)

    fun injectSumOperationFragment(sumOperationFragment: SumOperationFragment)

    fun injectTypeOperationFragment(typeOperationFragment: TypeOperationFragment)
}
