package com.example.koshelok.ui.listwallet

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WalletListViewModel : ViewModel() {

    val balanceData: LiveData<BalanceModel>
        get() = _balanceData
    val walletsData: LiveData<List<Wallet>>
        get() = _walletsData
    private val _balanceData = MutableLiveData<BalanceModel>()
    private val _walletsData = MutableLiveData<List<Wallet>>()

    init {
        uploadBalance()
        uploadWallets()
    }

    private fun uploadBalance() {
        //TODO загружать из сервака
        _balanceData.value = BalanceModel("100000", "100024", "351")
    }

    private fun uploadWallets() {
        //TODO загружать из сервака
        _walletsData.value = listOf(
            Wallet(FIRST_ID, "Кошелек 1", "12458", "35235", false),
            Wallet(SECOND_ID, "Кошелек 2", "1258", "35235", false),
            Wallet(THIRD_ID, "Кошелек 3", "177258", "65235", false),
            Wallet(FOURTH_ID, "Кошелек 4", "18", "235", false),
        )
    }

    private companion object {
        const val FIRST_ID = 1L
        const val SECOND_ID = 1L
        const val THIRD_ID = 1L
        const val FOURTH_ID = 1L
    }
}
