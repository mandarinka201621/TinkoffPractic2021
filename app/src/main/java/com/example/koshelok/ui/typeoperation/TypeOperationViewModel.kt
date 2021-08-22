package com.example.koshelok.ui.typeoperation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.koshelok.domain.TypeOperation
import com.example.koshelok.ui.model.Transaction
import javax.inject.Inject

class TypeOperationViewModel @Inject constructor() : ViewModel() {

    val typeOperation: LiveData<TypeOperation>
        get() = _typeOperation
    val transaction: LiveData<Transaction>
        get() = _transaction

    private val _typeOperation = MutableLiveData<TypeOperation>()
    private val _transaction = MutableLiveData<Transaction>()

    fun setSelectType(select: TypeOperation) {
        _typeOperation.value = select
        TypeOperation.valueOf(select.name)
    }

    fun setSelectType(transaction: Transaction) {
        _transaction.value = transaction
    }
}
