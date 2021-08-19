package com.example.koshelok.ui.typeoperation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TypeOperationViewModel : ViewModel() {

    private val _typeOperation = MutableLiveData<Select>()
    val typeOperation: LiveData<Select>
        get() = _typeOperation

    fun setSelectType(select: Select) {
        _typeOperation.value = select
        Select.valueOf(select.name)
    }

    enum class Select {
        SELECT_INCOME,
        SELECT_EXPENSE
    }
}
