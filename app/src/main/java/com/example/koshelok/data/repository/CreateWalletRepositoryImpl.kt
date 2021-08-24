package com.example.koshelok.data.repository

import com.example.koshelok.data.mappers.CreateWalletEntityToWalletApi
import com.example.koshelok.data.mappers.ResponseWithWalletApiToEntityMapper
import com.example.koshelok.data.service.AppService
import com.example.koshelok.domain.repository.CreateWalletRepository
import com.example.koshelok.ui.editwallet.ResponseWithWalletEntity
import com.example.koshelok.ui.entity.CreateWalletEntity
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class CreateWalletRepositoryImpl @Inject constructor(
    private val appService: AppService,
    private val mapperWallet: CreateWalletEntityToWalletApi,
    private val responseMapper: ResponseWithWalletApiToEntityMapper
) : CreateWalletRepository {
    override fun createWallet(
        personId: Long,
        createWallet: CreateWalletEntity
    ): Single<ResponseWithWalletEntity> {
        return appService.createWallet(
            mapperWallet(personId, createWallet)
        )
            .map(responseMapper)

    }

}
