package com.example.koshelok.domain.usecase

import com.example.koshelok.domain.repository.ListWalletRepository
import com.example.koshelok.ui.listwallet.entity.ExchangeRatesEntity
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

interface ExchangeRatesUseCase {
    operator fun invoke(): Single<ExchangeRatesEntity>
}

class ExchangeRatesUseCaseImpl @Inject constructor(
    private val listWalletRepository: ListWalletRepository
) : ExchangeRatesUseCase {

    override fun invoke(): Single<ExchangeRatesEntity> {
        return listWalletRepository.getExchangeRates()
    }
}
