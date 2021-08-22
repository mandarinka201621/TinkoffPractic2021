package com.example.koshelok.di.module

import com.example.koshelok.data.service.repimpl.DetailWalletRepositoryImpl
import com.example.koshelok.domain.repository.DetailWalletRepository
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
}
