package com.example.koshelok.di.module

import com.example.koshelok.data.db.source.DetailWalletSource
import com.example.koshelok.data.db.source.DetailWalletSourceImpl
import com.example.koshelok.data.db.source.MainWalletSource
import com.example.koshelok.data.db.source.MainWalletSourceImpl
import com.example.koshelok.data.db.source.WalletSource
import com.example.koshelok.data.db.source.WalletSourceImpl
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
