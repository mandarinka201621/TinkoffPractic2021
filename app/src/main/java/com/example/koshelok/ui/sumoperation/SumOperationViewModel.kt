package com.example.koshelok.ui.sumoperation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.koshelok.ui.entity.TransactionEntity
import javax.inject.Inject

class SumOperationViewModel @Inject constructor() : ViewModel() {

    val transactionEntity: LiveData<TransactionEntity>
        get() = _transaction

    private val _transaction = MutableLiveData<TransactionEntity>()

    fun setSumType(transactionEntity: TransactionEntity) {
        _transaction.value = transactionEntity
    }
}
