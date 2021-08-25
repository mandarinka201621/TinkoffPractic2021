package com.example.koshelok.di.module

import com.example.koshelok.data.db.DetailWalletSource
import com.example.koshelok.data.db.DetailWalletSourceImpl
import com.example.koshelok.data.db.MainWalletSource
import com.example.koshelok.data.db.MainWalletSourceImpl
import com.example.koshelok.data.db.WalletSource
import com.example.koshelok.data.db.WalletSourceImpl
import dagger.Binds
import dagger.Module

@Module
interface SourceModule {

    @Binds
    fun bindsDetailWalletSource(detailWalletSourceImpl: DetailWalletSourceImpl): DetailWalletSource

    @Binds
    fun bindsMainWalletSource(mainWalletSourceImpl: MainWalletSourceImpl): MainWalletSource

    @Binds
    fun bindsWalletSource(walletSourceImpl: WalletSourceImpl): WalletSource
}
