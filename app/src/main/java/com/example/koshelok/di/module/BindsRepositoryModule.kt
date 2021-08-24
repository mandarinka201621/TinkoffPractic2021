package com.example.koshelok.di.module

import com.example.koshelok.data.repository.ActionTransactionRepositoryImpl
import com.example.koshelok.data.repository.CreateCategoryRepositoryImpl
import com.example.koshelok.data.repository.CreateWalletRepositoryImpl
import com.example.koshelok.data.repository.DeleteTransactionRepositoryImpl
import com.example.koshelok.data.repository.DetailWalletRepositoryImpl
import com.example.koshelok.data.repository.LoadCategoriesRepositoryImpl
import com.example.koshelok.data.repository.MainScreenRepositoryImpl
import com.example.koshelok.data.repository.RegistrationRepositoryImpl
import com.example.koshelok.domain.repository.ActionTransactionRepository
import com.example.koshelok.domain.repository.CreateCategoryRepository
import com.example.koshelok.domain.repository.CreateWalletRepository
import com.example.koshelok.domain.repository.DeleteTransactionRepository
import com.example.koshelok.domain.repository.DetailWalletRepository
import com.example.koshelok.domain.repository.LoadCategoriesRepository
import com.example.koshelok.domain.repository.MainScreenRepository
import com.example.koshelok.domain.repository.RegistrationRepository
import dagger.Binds
import dagger.Module

@Module
interface BindsRepositoryModule {

    @Binds
    fun bindDetailWalletRepository(detailWalletRepositoryImpl: DetailWalletRepositoryImpl)
            : DetailWalletRepository

    @Binds
    fun bindListWalletRepository(listWalletRepositoryImpl: MainScreenRepositoryImpl)
            : MainScreenRepository

    @Binds
    fun bindOptionTransactionRepository(optionsTransactionRepositoryImpl: DeleteTransactionRepositoryImpl)
            : DeleteTransactionRepository

    @Binds
    fun bindActionTransactionRepository(actionTransactionRepositoryImpl: ActionTransactionRepositoryImpl)
            : ActionTransactionRepository

    @Binds
    fun bindCreateWalletRepository(createWalletRepositoryImpl: CreateWalletRepositoryImpl)
            : CreateWalletRepository

    @Binds
    fun bindLoadCategoriesRepository(loadCategoriesRepositoryImpl: LoadCategoriesRepositoryImpl)
            : LoadCategoriesRepository

    @Binds
    fun bindRegistrationRepository(registrationRepositoryImpl: RegistrationRepositoryImpl)
            : RegistrationRepository

    @Binds
    fun bindCreateCategoryRepository(createCategoryRepositoryImpl: CreateCategoryRepositoryImpl)
            : CreateCategoryRepository
}
