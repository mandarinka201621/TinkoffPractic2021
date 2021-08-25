package com.example.koshelok.ui.transactions.typeoperation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.koshelok.domain.TypeOperation
import com.example.koshelok.ui.util.entity.TransactionEntity
import javax.inject.Inject

class TypeOperationViewModel @Inject constructor() : ViewModel() {

    val typeOperation: LiveData<TypeOperation>
        get() = _typeOperation
    val transactionEntity: LiveData<TransactionEntity>
        get() = _transaction

    private val _typeOperation = MutableLiveData<TypeOperation>()
    private val _transaction = MutableLiveData<TransactionEntity>()

    fun setSelectType(type: TypeOperation) {
        _typeOperation.value = type
    }

    fun setSelectTransaction(transactionEntity: TransactionEntity) {
        _transaction.value = transactionEntity
    }
}
