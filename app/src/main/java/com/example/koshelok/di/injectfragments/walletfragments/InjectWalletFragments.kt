package com.example.koshelok.di.injectfragments.walletfragments

import com.example.koshelok.ui.detailwallet.DetailWalletFragment
import com.example.koshelok.ui.listwallet.ListWalletFragment
import com.example.koshelok.ui.onboarding.OnBoardingScreenFragment
import com.example.koshelok.ui.wallet.currencywallet.CurrencyWalletFragment
import com.example.koshelok.ui.wallet.editwallet.EditWalletFragment
import com.example.koshelok.ui.wallet.limitwallet.LimitWalletFragment

interface InjectWalletFragments {

    fun inject(limitWalletFragment: LimitWalletFragment)

    fun inject(onBoardingScreenFragment: OnBoardingScreenFragment)

    fun inject(detailWalletFragment: DetailWalletFragment)

    fun inject(listWalletFragment: ListWalletFragment)

    fun inject(editWalletFragment: EditWalletFragment)

    fun inject(currencyWalletFragment: CurrencyWalletFragment)
}
