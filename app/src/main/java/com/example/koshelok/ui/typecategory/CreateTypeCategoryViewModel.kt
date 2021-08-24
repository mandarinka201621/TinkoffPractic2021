package com.example.koshelok.ui.typecategory

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.koshelok.domain.TypeOperation
import javax.inject.Inject

class CreateTypeCategoryViewModel @Inject constructor() : ViewModel() {

    val typeCategory: LiveData<TypeOperation>
        get() = _typeCategory

    private val _typeCategory = MutableLiveData<TypeOperation>()

    fun setSelectType(select: TypeOperation) {
        _typeCategory.value = select
    }
}
