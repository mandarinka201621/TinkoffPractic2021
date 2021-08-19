package com.example.koshelok.ui.detailwallet

import androidx.lifecycle.ViewModel
import com.example.koshelok.DataList
import com.example.koshelok.domain.Category

class DetailWalletViewModel : ViewModel() {
    private val data = mutableListOf<DetailWalletItem.Transaction>()

    init {
        data.addAll(getData())
    }

    private fun getData(): List<DetailWalletItem.Transaction> {
        //TODO потом заменить на получение данных из сервака
        return DataList.data
    }

    fun addTransaction(transaction: DetailWalletItem.Transaction): List<DetailWalletItem> {
        data.add(transaction)
        return changeData()
    }

    fun changeData(): List<DetailWalletItem> {
        var income = 0
        var consumption = 0
        data.forEach { transaction ->
            if (transaction.category is Category.Income) {
                income += transaction.money
            } else {
                consumption += transaction.money
            }
        }
        val headerDetailWallet = DetailWalletItem.HeaderDetailWallet(
            amountMoney = income - consumption,
            income = income,
            consumption = consumption,
            limit = 10000
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
