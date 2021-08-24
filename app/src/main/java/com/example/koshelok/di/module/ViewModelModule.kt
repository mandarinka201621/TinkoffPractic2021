package com.example.koshelok.di.module

import androidx.lifecycle.ViewModel
import com.example.koshelok.di.ViewModelKey
import com.example.koshelok.ui.addoperation.AddOperationViewModel
import com.example.koshelok.ui.categoryoperation.CategoryViewModel
import com.example.koshelok.ui.detailwallet.DetailWalletViewModel
import com.example.koshelok.ui.editwallet.EditWalletViewModel
import com.example.koshelok.ui.listwallet.WalletListViewModel
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
    @[IntoMap ViewModelKey(WalletListViewModel::class)]
    fun bindWalletListViewModel(walletListViewModel: WalletListViewModel): ViewModel

    @Binds
    @[IntoMap ViewModelKey(SumOperationViewModel::class)]
    fun bindDetailListViewModel(sumOperationViewModel: SumOperationViewModel): ViewModel

    @Binds
    @[IntoMap ViewModelKey(TypeOperationViewModel::class)]
    fun bindTypeOperationViewModel(typeOperationViewModel: TypeOperationViewModel): ViewModel

    @Binds
    @[IntoMap ViewModelKey(EditWalletViewModel::class)]
    fun bindEditWalletViewModel(editWalletViewModel: EditWalletViewModel): ViewModel
}
