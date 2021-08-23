package com.example.koshelok.domain.repository

import com.example.koshelok.ui.detailwallet.DetailWalletItem
import io.reactivex.rxjava3.core.Single

interface DetailWalletRepository {

    fun getTransactions(walletId: Long): Single<List<DetailWalletItem>>

    fun getDataWallet(walletId: Long): Single<DetailWalletItem.HeaderDetailWallet>
}
