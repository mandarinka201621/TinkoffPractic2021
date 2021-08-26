package com.example.koshelok.domain.usecase

import com.example.koshelok.domain.repository.DetailWalletRepository
import com.example.koshelok.ui.detailwallet.DetailWalletItem
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

interface HeaderWalletUseCase {

    operator fun invoke(walletId: Long): Observable<DetailWalletItem.HeaderDetailWallet>

}

class HeaderHeaderWalletUseCaseImpl @Inject constructor(
    private val detailWalletRepository: DetailWalletRepository
) : HeaderWalletUseCase {

    override fun invoke(walletId: Long): Observable<DetailWalletItem.HeaderDetailWallet> {
        return detailWalletRepository.getDataWallet(walletId)
    }
}
