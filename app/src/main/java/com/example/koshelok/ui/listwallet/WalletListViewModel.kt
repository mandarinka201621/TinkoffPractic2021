package com.example.koshelok.ui.listwallet

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.koshelok.ui.listwallet.model.BalanceModel
import com.example.koshelok.ui.listwallet.model.ExchangeRatesModel
import com.example.koshelok.ui.listwallet.model.WalletModel

class WalletListViewModel : ViewModel() {

    val balanceData: LiveData<BalanceModel>
        get() = _balanceData
    val exchangeRatesData: LiveData<ExchangeRatesModel>
        get() = _exchangeRatesData
    val walletsData: LiveData<List<WalletModel>>
        get() = _walletsData
    private val _balanceData = MutableLiveData<BalanceModel>()
    private val _exchangeRatesData = MutableLiveData<ExchangeRatesModel>()
    private val _walletsData = MutableLiveData<List<WalletModel>>()

    init {
        uploadBalance()
        uploadExchangeRates()
        uploadWallets()
    }

    private fun uploadBalance() {
        //TODO загружать из сервака

    }

    private fun uploadExchangeRates() {
        //TODO загружать из сервера
    }

    private fun uploadWallets() {
        //TODO загружать из сервака
    }

}
