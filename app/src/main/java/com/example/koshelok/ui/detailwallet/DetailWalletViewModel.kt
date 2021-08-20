package com.example.koshelok.ui.detailwallet

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.koshelok.DataList

class DetailWalletViewModel : ViewModel() {
    private val data = mutableListOf<DetailWalletItem.Transaction>()
    private val detailWalletData = MutableLiveData<List<DetailWalletItem>>()

    init {
        data.addAll(uploadData())
        detailWalletData.value = changeData()
    }

    private fun uploadData(): List<DetailWalletItem.Transaction> {
        //TODO потом заменить на получение данных из сервака
        return DataList.data
    }

    fun getData(): LiveData<List<DetailWalletItem>> {
        return detailWalletData
    }

    fun addTransaction(transaction: DetailWalletItem.Transaction) {
        data.add(transaction)
        detailWalletData.value = changeData()
    }

    fun deleteTransaction(transaction: DetailWalletItem.Transaction) {
        data.remove(transaction)
        detailWalletData.value = changeData()
    }

    private fun changeData(): List<DetailWalletItem> {
        val headerDetailWallet = DetailWalletItem.HeaderDetailWallet(
            amountMoney = "9000 ₽",
            nameWallet = "Кошелек 1",
            income = "7000 ₽",
            consumption = "2000 ₽",
            limit = "/10000 ₽",
            currency = "рубль"
        )
        return mutableListOf<DetailWalletItem>().apply {
            add(headerDetailWallet)
            data.groupBy { it.day }.forEach { (key, list) ->
                add(DetailWalletItem.Day(key))
                addAll(list.sortedBy { it.time }.reversed())
            }
        }
    }
}
