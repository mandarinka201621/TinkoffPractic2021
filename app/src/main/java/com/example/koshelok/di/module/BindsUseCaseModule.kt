package com.example.koshelok.di.module

import com.example.koshelok.domain.usecase.CreateCategoryUseCase
import com.example.koshelok.domain.usecase.CreateCategoryUseCaseImpl
import com.example.koshelok.domain.usecase.CreateTransactionUseCase
import com.example.koshelok.domain.usecase.CreateTransactionUseCaseImpl
import com.example.koshelok.domain.usecase.CreateWalletUseCase
import com.example.koshelok.domain.usecase.CreateWalletUseCaseImpl
import com.example.koshelok.domain.usecase.DetailWalletUseCase
import com.example.koshelok.domain.usecase.DetailWalletUseCaseImpl
import com.example.koshelok.domain.usecase.EditTransactionUseCase
import com.example.koshelok.domain.usecase.EditTransactionUseCaseImpl
import com.example.koshelok.domain.usecase.LoadCategoriesUseCase
import com.example.koshelok.domain.usecase.LoadCategoriesUseCaseImpl
import com.example.koshelok.domain.usecase.MainScreenUseCase
import com.example.koshelok.domain.usecase.MainScreenUseCaseImpl
import com.example.koshelok.domain.usecase.RegistrationUserUseCase
import com.example.koshelok.domain.usecase.RegistrationUserUseCaseImpl
import dagger.Binds
import dagger.Module

@Module
interface BindsUseCaseModule {

    @Binds
    fun bindDetailWalletUseCase(detailWalletUseCaseImpl: DetailWalletUseCaseImpl): DetailWalletUseCase

    @Binds
    fun bindWalletsUseCase(walletsUseCaseImpl: MainScreenUseCaseImpl): MainScreenUseCase

    @Binds
    fun bindAddTransactionUseCase(addTransactionUseCaseImpl: CreateTransactionUseCaseImpl)
            : CreateTransactionUseCase

    @Binds
    fun bindEditTransactionUseCase(editTransactionUseCaseImpl: EditTransactionUseCaseImpl)
            : EditTransactionUseCase

    @Binds
    fun bindCreateWalletUseCase(createWalletUseCaseImpl: CreateWalletUseCaseImpl): CreateWalletUseCase

    @Binds
    fun bindLoadCategoriesUseCase(loadCategoriesUseCaseImpl: LoadCategoriesUseCaseImpl)
            : LoadCategoriesUseCase

    @Binds
    fun bindRegistrationUserUseCase(registrationUserUseCaseImpl: RegistrationUserUseCaseImpl)
            : RegistrationUserUseCase

    @Binds
    fun bindCreateCategoryUseCase(createCategoryUseCaseImpl: CreateCategoryUseCaseImpl)
            : CreateCategoryUseCase
}
