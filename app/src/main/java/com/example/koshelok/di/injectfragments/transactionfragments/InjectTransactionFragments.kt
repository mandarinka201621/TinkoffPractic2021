package com.example.koshelok.di.injectfragments.transactionfragments

import com.example.koshelok.ui.categories.categoryoperation.CategoryOperationFragment
import com.example.koshelok.ui.transactions.addoperation.AddOperationFragment
import com.example.koshelok.ui.transactions.sumoperation.SumOperationFragment
import com.example.koshelok.ui.transactions.typeoperation.TypeOperationFragment

interface InjectTransactionFragments {

    fun inject(addOperationFragment: AddOperationFragment)

    fun inject(sumOperationFragment: SumOperationFragment)

    fun inject(categoryOperationFragment: CategoryOperationFragment)

    fun inject(typeOperationFragment: TypeOperationFragment)
}
