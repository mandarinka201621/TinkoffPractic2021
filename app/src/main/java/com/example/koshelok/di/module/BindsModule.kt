package com.example.koshelok.di.module

import com.example.koshelok.data.service.repimpl.ActionTransactionRepositoryImp
import com.example.koshelok.data.service.repimpl.DeleteTransactionRepositoryImpl
import com.example.koshelok.data.service.repimpl.DetailWalletRepositoryImpl
import com.example.koshelok.data.service.repimpl.ListWalletRepositoryImpl
import com.example.koshelok.domain.repository.ActionTransactionRepository
import com.example.koshelok.domain.repository.DeleteTransactionRepository
import com.example.koshelok.domain.repository.DetailWalletRepository
import com.example.koshelok.domain.repository.ListWalletRepository
import com.example.koshelok.domain.usecase.DetailWalletUseCase
import com.example.koshelok.domain.usecase.DetailWalletUseCaseImpl
import dagger.Binds
import dagger.Module

@Module
interface BindsModule {

    @Binds
    fun bindDetailWalletRepository(detailWalletRepositoryImpl: DetailWalletRepositoryImpl)
            : DetailWalletRepository

    @Binds
    fun bindDetailUseCase(detailWalletUseCaseImpl: DetailWalletUseCaseImpl): DetailWalletUseCase

    @Binds
    fun bindListWalletRepository(listWalletRepositoryImpl: ListWalletRepositoryImpl)
            : ListWalletRepository

    @Binds
    fun bindOptionTransactionRepository(optionsTransactionRepositoryImpl: DeleteTransactionRepositoryImpl)
            : DeleteTransactionRepository

    @Binds
    fun bindActionTransactionRepository(actionTransactionRepositoryImp: ActionTransactionRepositoryImp)
            : ActionTransactionRepository
}
