package com.example.koshelok.domain.usecase

import com.example.koshelok.domain.repository.CreateWalletRepository
import com.example.koshelok.ui.entity.CreateWalletEntity
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

interface CreateWalletUseCase {

    operator fun invoke(
        personId: Long,
        createWalletEntity: CreateWalletEntity
    ): Single<Long>
}

class CreateWalletUseCaseImpl @Inject constructor(
    private val createWalletRepository: CreateWalletRepository
) : CreateWalletUseCase {

    override fun invoke(
        personId: Long,
        createWalletEntity: CreateWalletEntity
    ): Single<Long> {
        return createWalletRepository.createWallet(personId, createWalletEntity)
    }
}
