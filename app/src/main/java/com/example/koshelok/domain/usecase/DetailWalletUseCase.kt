package com.example.koshelok.domain.usecase

import com.example.koshelok.domain.repository.DetailWalletRepository
import com.example.koshelok.ui.detailwallet.DetailWalletItem
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

interface DetailWalletUseCase {

    operator fun invoke(walletId: Long): Observable<List<DetailWalletItem>>
}

class DetailWalletUseCaseImpl @Inject constructor(
    private val detailWalletRepository: DetailWalletRepository
) : DetailWalletUseCase {
    override fun invoke(walletId: Long): Observable<List<DetailWalletItem>> {
        return detailWalletRepository.getDetailWalletData(walletId)
    }
}
