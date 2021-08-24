package com.example.koshelok.domain.usecase

import com.example.koshelok.domain.repository.DetailWalletRepository
import com.example.koshelok.ui.detailwallet.DetailWalletItem
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

interface HeaderWalletUseCase {

    operator fun invoke(walletId: Long): Single<DetailWalletItem.HeaderDetailWallet>

}

class HeaderHeaderWalletUseCaseImpl @Inject constructor(
    private val detailWalletRepository: DetailWalletRepository
) : HeaderWalletUseCase {

    override fun invoke(walletId: Long): Single<DetailWalletItem.HeaderDetailWallet> {
        return detailWalletRepository.getDataWallet(walletId)
    }
}
