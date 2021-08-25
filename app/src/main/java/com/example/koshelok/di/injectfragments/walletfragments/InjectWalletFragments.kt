package com.example.koshelok.di.injectfragments.walletfragments

import com.example.koshelok.ui.detailwallet.DetailWalletFragment
import com.example.koshelok.ui.editwallet.EditWalletFragment
import com.example.koshelok.ui.limitwallet.LimitWalletFragment
import com.example.koshelok.ui.listwallet.ListWalletFragment
import com.example.koshelok.ui.onboarding.OnBoardingScreenFragment

interface InjectWalletFragments {

    fun inject(limitWalletFragment: LimitWalletFragment)

    fun inject(onBoardingScreenFragment: OnBoardingScreenFragment)

    fun inject(detailWalletFragment: DetailWalletFragment)

    fun inject(listWalletFragment: ListWalletFragment)

    fun inject(editWalletFragment: EditWalletFragment)
}
