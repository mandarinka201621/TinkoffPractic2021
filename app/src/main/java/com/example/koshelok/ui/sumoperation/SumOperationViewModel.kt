package com.example.koshelok.ui.sumoperation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.koshelok.ui.model.Transaction

class SumOperationViewModel : ViewModel() {

    val transaction: LiveData<Transaction>
        get() = _transaction

    private val _transaction = MutableLiveData<Transaction>()

    fun setSumType(transaction: Transaction) {
        _transaction.value = transaction
    }
}
