package com.example.koshelok.ui.listwallet

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.koshelok.ui.listwallet.entity.BalancEntity
import com.example.koshelok.ui.listwallet.entity.ExchangeRatesEntity
import com.example.koshelok.ui.listwallet.entity.WalletEntity

class WalletListViewModel : ViewModel() {

    val balanceData: LiveData<BalancEntity>
        get() = _balanceData
    val exchangeRatesData: LiveData<ExchangeRatesEntity>
        get() = _exchangeRatesData
    val walletsData: LiveData<List<WalletEntity>>
        get() = _walletsData
    private val _balanceData = MutableLiveData<BalancEntity>()
    private val _exchangeRatesData = MutableLiveData<ExchangeRatesEntity>()
    private val _walletsData = MutableLiveData<List<WalletEntity>>()

    init {
        uploadBalance()
        uploadExchangeRates()
        uploadWallets()
    }

    private fun uploadBalance() {
        //TODO загружать из сервака
        _walletsData.value = listOf()
    }

    private fun uploadExchangeRates() {
        //TODO загружать из сервера
    }

    private fun uploadWallets() {
        //TODO загружать из сервака
    }

}
