package com.example.koshelok.data.repository

import com.example.koshelok.data.db.source.WalletSource
import com.example.koshelok.data.mappers.category.CreateWalletEntityToWalletApiMapper
import com.example.koshelok.data.service.AppService
import com.example.koshelok.domain.repository.CreateWalletRepository
import com.example.koshelok.ui.util.entity.CreateWalletEntity
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class CreateWalletRepositoryImpl @Inject constructor(
    private val appService: AppService,
    private val mapperWallet: CreateWalletEntityToWalletApiMapper,
    private val walletSource: WalletSource
) : CreateWalletRepository {
    override fun createWallet(
        personId: Long,
        createWallet: CreateWalletEntity
    ): Single<Long> {
        return appService.createWallet(mapperWallet(null, personId, createWallet))
            .doOnSuccess { id ->
                walletSource.insertWallet(mapperWallet(id, personId, createWallet))
            }
    }
}
