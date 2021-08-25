package com.example.koshelok.di.injectfragments.transactionfragments

import com.example.koshelok.ui.addoperation.AddOperationFragment
import com.example.koshelok.ui.categoryoperation.CategoryOperationFragment
import com.example.koshelok.ui.sumoperation.SumOperationFragment
import com.example.koshelok.ui.typeoperation.TypeOperationFragment

interface InjectTransactionFragments {

    fun inject(addOperationFragment: AddOperationFragment)

    fun inject(sumOperationFragment: SumOperationFragment)

    fun inject(categoryOperationFragment: CategoryOperationFragment)

    fun inject(typeOperationFragment: TypeOperationFragment)
}
