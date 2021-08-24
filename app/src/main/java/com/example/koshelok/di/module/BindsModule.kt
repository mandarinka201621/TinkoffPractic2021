package com.example.koshelok.di.module

import com.example.koshelok.data.repository.ActionTransactionRepositoryImpl
import com.example.koshelok.data.repository.DeleteTransactionRepositoryImpl
import com.example.koshelok.data.repository.DetailWalletRepositoryImpl
import com.example.koshelok.data.repository.ListWalletRepositoryImpl
import com.example.koshelok.domain.repository.ActionTransactionRepository
import com.example.koshelok.domain.repository.DeleteTransactionRepository
import com.example.koshelok.domain.repository.DetailWalletRepository
import com.example.koshelok.domain.repository.ListWalletRepository
import com.example.koshelok.domain.usecase.BalanceUseCase
import com.example.koshelok.domain.usecase.BalanceUseCaseImpl
import com.example.koshelok.domain.usecase.ExchangeRatesUseCase
import com.example.koshelok.domain.usecase.ExchangeRatesUseCaseImpl
import com.example.koshelok.domain.usecase.HeaderHeaderWalletUseCaseImpl
import com.example.koshelok.domain.usecase.HeaderWalletUseCase
import com.example.koshelok.domain.usecase.TransactionsUseCase
import com.example.koshelok.domain.usecase.TransactionsUseCaseImpl
import com.example.koshelok.domain.usecase.WalletsUseCase
import com.example.koshelok.domain.usecase.WalletsUseCaseImpl
import dagger.Binds
import dagger.Module

@Module
interface BindsModule {

    @Binds
    fun bindDetailWalletRepository(detailWalletRepositoryImpl: DetailWalletRepositoryImpl)
            : DetailWalletRepository

    @Binds
    fun bindTransactionUseCase(transactionsUseCaseImpl: TransactionsUseCaseImpl): TransactionsUseCase

    @Binds
    fun bindListWalletRepository(listWalletRepositoryImpl: ListWalletRepositoryImpl)
            : ListWalletRepository

    @Binds
    fun bindOptionTransactionRepository(optionsTransactionRepositoryImpl: DeleteTransactionRepositoryImpl)
            : DeleteTransactionRepository

    @Binds
    fun bindActionTransactionRepository(actionTransactionRepositoryImpl: ActionTransactionRepositoryImpl)
            : ActionTransactionRepository

    @Binds
    fun bindHeaderWalletUseCase(headerHeaderWalletUseCaseImpl: HeaderHeaderWalletUseCaseImpl): HeaderWalletUseCase

    @Binds
    fun bindWalletsUseCase(walletsUseCaseImpl: WalletsUseCaseImpl): WalletsUseCase

    @Binds
    fun bindExchangeRatesUseCase(exchangeRatesUseCaseImpl: ExchangeRatesUseCaseImpl): ExchangeRatesUseCase

    @Binds
    fun bindBalanceUseCase(balanceUseCaseImpl: BalanceUseCaseImpl): BalanceUseCase
}
