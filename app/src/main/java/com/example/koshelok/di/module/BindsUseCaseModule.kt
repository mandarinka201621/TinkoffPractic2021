package com.example.koshelok.di.module

import com.example.koshelok.domain.usecase.BalanceUseCase
import com.example.koshelok.domain.usecase.BalanceUseCaseImpl
import com.example.koshelok.domain.usecase.CreateTransactionUseCase
import com.example.koshelok.domain.usecase.CreateTransactionUseCaseImpl
import com.example.koshelok.domain.usecase.CreateWalletUseCase
import com.example.koshelok.domain.usecase.CreateWalletUseCaseImpl
import com.example.koshelok.domain.usecase.EditTransactionUseCase
import com.example.koshelok.domain.usecase.EditTransactionUseCaseImpl
import com.example.koshelok.domain.usecase.ExchangeRatesUseCase
import com.example.koshelok.domain.usecase.ExchangeRatesUseCaseImpl
import com.example.koshelok.domain.usecase.HeaderHeaderWalletUseCaseImpl
import com.example.koshelok.domain.usecase.HeaderWalletUseCase
import com.example.koshelok.domain.usecase.LoadCategoriesUseCase
import com.example.koshelok.domain.usecase.LoadCategoriesUseCaseImpl
import com.example.koshelok.domain.usecase.TransactionsUseCase
import com.example.koshelok.domain.usecase.TransactionsUseCaseImpl
import com.example.koshelok.domain.usecase.WalletsUseCase
import com.example.koshelok.domain.usecase.WalletsUseCaseImpl
import dagger.Binds
import dagger.Module

@Module
interface BindsUseCaseModule {

    @Binds
    fun bindTransactionUseCase(transactionsUseCaseImpl: TransactionsUseCaseImpl): TransactionsUseCase

    @Binds
    fun bindHeaderWalletUseCase(headerHeaderWalletUseCaseImpl: HeaderHeaderWalletUseCaseImpl): HeaderWalletUseCase

    @Binds
    fun bindWalletsUseCase(walletsUseCaseImpl: WalletsUseCaseImpl): WalletsUseCase

    @Binds
    fun bindExchangeRatesUseCase(exchangeRatesUseCaseImpl: ExchangeRatesUseCaseImpl): ExchangeRatesUseCase

    @Binds
    fun bindBalanceUseCase(balanceUseCaseImpl: BalanceUseCaseImpl): BalanceUseCase

    @Binds
    fun bindAddTransactionUseCase(addTransactionUseCaseImpl: CreateTransactionUseCaseImpl): CreateTransactionUseCase

    @Binds
    fun bindEditTransactionUseCase(editTransactionUseCaseImpl: EditTransactionUseCaseImpl): EditTransactionUseCase

    @Binds
    fun bindCreateWalletUseCase(createWalletUseCaseImpl: CreateWalletUseCaseImpl): CreateWalletUseCase

    @Binds
    fun bindLoadCategoriesUseCase(loadCategoriesUseCaseImpl: LoadCategoriesUseCaseImpl): LoadCategoriesUseCase
}
