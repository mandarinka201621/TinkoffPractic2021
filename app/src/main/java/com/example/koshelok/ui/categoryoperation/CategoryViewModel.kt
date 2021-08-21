package com.example.koshelok.ui.categoryoperation

import android.graphics.Color
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.koshelok.R
import com.example.koshelok.ui.model.CategoryModel
import com.example.koshelok.ui.model.Transaction

class CategoryViewModel : ViewModel() {

    val listCategoryModel = MutableLiveData<List<CategoryModel>>()

    private val transactionLiveData = MutableLiveData<Transaction>()

    private val categoryListValue: List<CategoryModel>
        get() = requireNotNull(listCategoryModel.value)

    init {
        listCategoryModel.value = listOf(
            CategoryModel(
                R.drawable.salary,
                "Собака",
                Color.parseColor("#00B92D"),
                false, NUMBER2
            ),
            CategoryModel(
                R.drawable.settings_icon,
                "На себя",
                Color.parseColor("#00B92D"),
                false, NUMBER3
            ),
            CategoryModel(
                R.drawable.salary,
                "Собака",
                Color.parseColor("#00B92D"),
                false, NUMBER4
            ),
            CategoryModel(
                R.drawable.settings_icon,
                "На себя",
                Color.parseColor("#00B92D"),
                false, NUMBER5
            )
        )
    }

    fun setSelectCategory(transaction: Transaction) {
        transactionLiveData.value = transaction
    }

    fun isSelect(): Boolean = categoryListValue.any { it.isEnable }

    fun getEnableCategory() = categoryListValue.find { it.isEnable }

    fun changeEnableState(position: Int, categoryModelModule: CategoryModel) {
        if (!categoryModelModule.isEnable) {
            getEnableCategory()?.isEnable = false
            categoryListValue[position].isEnable = true
            updateLD()
        }
    }

    private fun updateLD() {
        listCategoryModel.value = listCategoryModel.value
    }

    companion object{
        const val NUMBER2 = 2
        const val NUMBER3 = 3
        const val NUMBER4 = 4
        const val NUMBER5 = 5
    }
}
