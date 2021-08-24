package com.example.koshelok.domain.usecase

import com.example.koshelok.domain.repository.ListWalletRepository
import com.example.koshelok.ui.listwallet.entity.BalanceEntity
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

interface BalanceUseCase {

    operator fun invoke(personId: Long): Single<BalanceEntity>
}

class BalanceUseCaseImpl @Inject constructor(
    private val listWalletRepository: ListWalletRepository
) : BalanceUseCase {

    override fun invoke(personId: Long): Single<BalanceEntity> {
        return listWalletRepository.getBalance(personId)
    }
}
