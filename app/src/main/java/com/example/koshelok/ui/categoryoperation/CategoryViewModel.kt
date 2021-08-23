package com.example.koshelok.ui.categoryoperation

import android.graphics.Color
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.koshelok.R
import com.example.koshelok.ui.entity.CategoryEntity
import com.example.koshelok.ui.entity.TransactionEntity
import javax.inject.Inject

class CategoryViewModel @Inject constructor() : ViewModel() {

    val listCategoryModel = MutableLiveData<List<CategoryEntity>>()

    private val transactionLiveData = MutableLiveData<TransactionEntity>()

    private val categoryListValue: List<CategoryEntity>
        get() = requireNotNull(listCategoryModel.value)

    init {
        listCategoryModel.value = listOf(
            CategoryEntity(
                R.drawable.salary,
                "Собака",
                Color.parseColor("#00B92D"),
                false, NUMBER2
            ),
            CategoryEntity(
                R.drawable.settings_icon,
                "На себя",
                Color.parseColor("#00B92D"),
                false, NUMBER3
            ),
            CategoryEntity(
                R.drawable.salary,
                "Собака",
                Color.parseColor("#00B92D"),
                false, NUMBER4
            ),
            CategoryEntity(
                R.drawable.settings_icon,
                "На себя",
                Color.parseColor("#00B92D"),
                false, NUMBER5
            )
        )
    }

    fun setSelectCategory(transactionEntity: TransactionEntity) {
        transactionLiveData.value = transactionEntity
    }

    fun isSelect(): Boolean = categoryListValue.any { it.isEnable }

    fun getEnableCategory() = categoryListValue.find { it.isEnable }

    fun changeEnableState(position: Int, categoryEntityModule: CategoryEntity) {
        if (!categoryEntityModule.isEnable) {
            getEnableCategory()?.isEnable = false
            categoryListValue[position].isEnable = true
            updateLD()
        }
    }

    private fun updateLD() {
        listCategoryModel.value = listCategoryModel.value
    }

    companion object{
        const val NUMBER2 = 2L
        const val NUMBER3 = 3L
        const val NUMBER4 = 4L
        const val NUMBER5 = 5L
    }
}
