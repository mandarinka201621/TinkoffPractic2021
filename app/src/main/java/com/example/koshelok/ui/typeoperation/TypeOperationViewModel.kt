package com.example.koshelok.ui.typeoperation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.koshelok.ui.model.Transaction

class TypeOperationViewModel : ViewModel() {

    val typeOperation: LiveData<Select>
        get() = _typeOperation
    val transaction: LiveData<Transaction>
        get() = _transaction

    private val _typeOperation = MutableLiveData<Select>()
    private val _transaction = MutableLiveData<Transaction>()

    fun setSelectType(select: Select) {
        _typeOperation.value = select
        Select.valueOf(select.name)
    }

    fun setSelectType(transaction: Transaction) {
        _transaction.value = transaction
    }

    enum class Select(val type: Boolean) {
        SELECT_INCOME(true),
        SELECT_EXPENSE(false)
    }
}
