package com.example.koshelok.ui.addoperation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.koshelok.ui.model.Transaction

class AddOperationViewModel : ViewModel() {

    val transaction: LiveData<Transaction>
        get() = _transaction

    private val _transaction = MutableLiveData<Transaction>()

    fun setTransaction(transaction: Transaction) {
        _transaction.value = transaction
    }
}
