package com.example.koshelok.ui.wallet.currencywallet

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.koshelok.domain.Currency
import com.example.koshelok.ui.util.entity.CurrencyEntity
import javax.inject.Inject

class CurrencyWalletFragmentViewModel @Inject constructor() : ViewModel() {

    val errorData: LiveData<Throwable>
        get() = _errorData

    val listCurrencyModel = MutableLiveData<List<CurrencyEntity>>()
    private val _errorData = MutableLiveData<Throwable>()

    private val currencyListValue: List<CurrencyEntity>
        get() = requireNotNull(listCurrencyModel.value)

    init {
        val newListCurrency = listOf(
            CurrencyEntity(Currency.RUB, true),
            CurrencyEntity(Currency.USD, false),
            CurrencyEntity(Currency.EUR, false),
            CurrencyEntity(Currency.CHF, false)
        )
        listCurrencyModel.value = newListCurrency
        updateLD()
    }

    fun getEnableCurrency() = currencyListValue.find { it.isEnable }

    fun changeEnableState(position: Int, currency: CurrencyEntity) {
        if (!currency.isEnable) {
            getEnableCurrency()?.isEnable = false
            currencyListValue[position].isEnable = true
            updateLD()
        }
    }

    private fun updateLD() {
        listCurrencyModel.value = listCurrencyModel.value
    }
}
