package com.example.koshelok.domain.usecase

import com.example.koshelok.domain.repository.DetailWalletRepository
import com.example.koshelok.ui.detailwallet.DetailWalletItem
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

interface TransactionsUseCase {

    operator fun invoke(walletId: Long): Observable<List<DetailWalletItem>>
}

class TransactionsUseCaseImpl @Inject constructor(
    private val detailWalletRepository: DetailWalletRepository
) : TransactionsUseCase {

    override fun invoke(walletId: Long): Observable<List<DetailWalletItem>> {
        return detailWalletRepository.getTransactions(walletId)
    }
}
