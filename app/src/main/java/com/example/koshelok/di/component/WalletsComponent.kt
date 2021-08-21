package com.example.koshelok.di.component

import com.example.koshelok.di.FragmentScope
import com.example.koshelok.ui.listwallet.WalletListFragment
import dagger.Component

@FragmentScope
@Component(dependencies = [AppComponent::class])
interface WalletsComponent {

    fun injectWalletsList(walletListFragment: WalletListFragment)
}
