package com.example.koshelok.domain.repository

import com.example.koshelok.ui.entity.CreateWalletEntity
import io.reactivex.rxjava3.core.Single

interface CreateWalletRepository {
    fun createWallet(
        personId: Long,
        createWallet: CreateWalletEntity
    ): Single<Long>
}
