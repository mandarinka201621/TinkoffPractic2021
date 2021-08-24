package com.example.koshelok.domain.usecase

import com.example.koshelok.domain.repository.ListWalletRepository
import com.example.koshelok.ui.listwallet.entity.WalletEntity
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

interface WalletsUseCase {
    operator fun invoke(personId: Long): Single<List<WalletEntity>>
}

class WalletsUseCaseImpl @Inject constructor(
    private val walletRepository: ListWalletRepository
) : WalletsUseCase {

    override fun invoke(personId: Long): Single<List<WalletEntity>> {
        return walletRepository.getListWallet(personId)
    }
}
