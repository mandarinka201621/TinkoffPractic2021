package com.example.koshelok.ui.categoryoperation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.koshelok.ui.model.CategoryModel
import com.example.koshelok.ui.model.Transaction

class CategoryViewModel : ViewModel() {

    val transaction: LiveData<Transaction>
        get() = _transaction
    val listCategoryModel: LiveData<List<CategoryModel>>
        get() = _listCategory

    private val _transaction = MutableLiveData<Transaction>()
    private val _listCategory = MutableLiveData<List<CategoryModel>>()
    private val categoryList = mutableListOf<CategoryModel>()

    fun setSelectCategory(transaction: Transaction) {
        _transaction.value = transaction
    }

    init {
        _listCategory.value = categoryList
        updateLD()
    }

    fun isSelect(): Boolean = categoryList.any { it.isEnable }

    fun getEnableCategory() = categoryList.find { it.isEnable }

    fun changeEnableState(position: Int, categoryModelModule: CategoryModel) {
        if (!categoryModelModule.isEnable) {
            categoryList.find { it.isEnable }?.isEnable = false
            categoryList[position].isEnable = true
            _listCategory.value = categoryList
            updateLD()
        }
    }

    fun getDate() = System.currentTimeMillis()

    private fun updateLD() {
        _listCategory.value = _listCategory.value
    }
}
