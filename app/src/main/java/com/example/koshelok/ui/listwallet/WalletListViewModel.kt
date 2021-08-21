package com.example.koshelok.ui.listwallet

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WalletListViewModel : ViewModel() {

    val balanceData: LiveData<BalanceModel>
        get() = _balanceData
    val walletsData: LiveData<List<WalletsListItem>>
        get() = _walletsData
    private val _balanceData = MutableLiveData<BalanceModel>()
    private val _walletsData = MutableLiveData<List<WalletsListItem>>()

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
    }

}
