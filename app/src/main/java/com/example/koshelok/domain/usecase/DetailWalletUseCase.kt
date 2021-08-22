package com.example.koshelok.domain.usecase

import com.example.koshelok.domain.repository.DetailWalletRepository
import com.example.koshelok.ui.detailwallet.DetailWalletItem
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

interface DetailWalletUseCase {

    operator fun invoke(walletId: Long): Single<List<DetailWalletItem>>
}

class DetailWalletUseCaseImpl @Inject constructor(
    private val detailWalletRepository: DetailWalletRepository
) : DetailWalletUseCase {

    override fun invoke(walletId: Long): Single<List<DetailWalletItem>> {
        return Single.zip(
            detailWalletRepository.getTransactions(walletId),
            detailWalletRepository.getDataWallet(walletId)
        ) { transactions, wallet ->
            return@zip mutableListOf<DetailWalletItem>(wallet).apply {
                addAll(transactions.reversed())
            }.toList()
        }
    }
}
