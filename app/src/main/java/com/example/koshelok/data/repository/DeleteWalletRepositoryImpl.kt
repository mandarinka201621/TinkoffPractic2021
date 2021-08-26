package com.example.koshelok.data.repository

import com.example.koshelok.data.db.source.WalletSource
import com.example.koshelok.data.service.AppService
import com.example.koshelok.domain.repository.DeleteWalletRepository
import io.reactivex.rxjava3.core.Completable
import javax.inject.Inject

class DeleteWalletRepositoryImpl @Inject constructor(
    private val appService: AppService,
    private val walletSource: WalletSource
) : DeleteWalletRepository {

    override fun deleteWallet(walletId: Long): Completable {
        return appService.deleteWallet(walletId).doOnComplete {
            walletSource.deleteWallet(walletId)
        }
    }
}
