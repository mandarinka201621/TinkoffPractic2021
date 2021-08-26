package com.example.koshelok.domain.repository

import com.example.koshelok.ui.detailwallet.DetailWalletItem
import io.reactivex.rxjava3.core.Observable

interface DetailWalletRepository {

    fun getDetailWalletData(walletId: Long): Observable<List<DetailWalletItem>>
}
