package com.example.koshelok.di.module

import androidx.lifecycle.ViewModel
import com.example.koshelok.di.ViewModelKey
import com.example.koshelok.ui.addoperation.AddOperationViewModel
import com.example.koshelok.ui.categoryoperation.CategoryViewModel
import com.example.koshelok.ui.detailwallet.DetailWalletViewModel
import com.example.koshelok.ui.editwallet.EditWalletViewModel
import com.example.koshelok.ui.listwallet.ListWalletViewModel
import com.example.koshelok.ui.onboarding.OnBoardScreenViewModel
import com.example.koshelok.ui.sumoperation.SumOperationViewModel
import com.example.koshelok.ui.typeoperation.TypeOperationViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    @[IntoMap ViewModelKey(AddOperationViewModel::class)]
    fun bindAddOperationViewModel(addOperationViewModel: AddOperationViewModel): ViewModel

    @Binds
    @[IntoMap ViewModelKey(CategoryViewModel::class)]
    fun bindCategoryViewModel(categoryViewModel: CategoryViewModel): ViewModel

    @Binds
    @[IntoMap ViewModelKey(DetailWalletViewModel::class)]
    fun bindDetailWalletViewModel(detailWalletViewModel: DetailWalletViewModel): ViewModel

    @Binds
    @[IntoMap ViewModelKey(ListWalletViewModel::class)]
    fun bindWalletListViewModel(listWalletViewModel: ListWalletViewModel): ViewModel

    @Binds
    @[IntoMap ViewModelKey(SumOperationViewModel::class)]
    fun bindDetailListViewModel(sumOperationViewModel: SumOperationViewModel): ViewModel

    @Binds
    @[IntoMap ViewModelKey(TypeOperationViewModel::class)]
    fun bindTypeOperationViewModel(typeOperationViewModel: TypeOperationViewModel): ViewModel

    @Binds
    @[IntoMap ViewModelKey(EditWalletViewModel::class)]
    fun bindEditWalletViewModel(editWalletViewModel: EditWalletViewModel): ViewModel

    @Binds
    @[IntoMap ViewModelKey(OnBoardScreenViewModel::class)]
    fun bindOnBoardScreenViewMode(onBoardScreenViewModel: OnBoardScreenViewModel): ViewModel
}
