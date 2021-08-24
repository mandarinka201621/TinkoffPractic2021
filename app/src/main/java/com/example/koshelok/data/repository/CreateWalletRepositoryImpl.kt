package com.example.koshelok.data.repository

import com.example.koshelok.data.mappers.CreateWalletEntityToWalletApi
import com.example.koshelok.data.service.AppService
import com.example.koshelok.domain.repository.CreateWalletRepository
import com.example.koshelok.ui.util.entity.CreateWalletEntity
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class CreateWalletRepositoryImpl @Inject constructor(
    private val appService: AppService,
    private val mapperWallet: CreateWalletEntityToWalletApi,
) : CreateWalletRepository {
    override fun createWallet(
        personId: Long,
        createWallet: CreateWalletEntity
    ): Single<Long> {
        return appService.createWallet(mapperWallet(personId, createWallet))
    }

}
