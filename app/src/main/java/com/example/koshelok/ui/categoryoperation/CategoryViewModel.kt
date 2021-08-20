package com.example.koshelok.ui.categoryoperation

import android.graphics.Color
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.koshelok.R
import com.example.koshelok.ui.model.CategoryModel
import com.example.koshelok.ui.model.Transaction

class CategoryViewModel : ViewModel() {

    val transaction: LiveData<Transaction>
        get() = _transaction
    val listCategoryModel: LiveData<List<CategoryModel>>
        get() = _listCategory

    private val _transaction = MutableLiveData<Transaction>()
    private val _listCategory = MutableLiveData<List<CategoryModel>>()
    private var autoIncrementId = 0
    private val categoryList = sortedSetOf<CategoryModel>(
        { o1, o2 -> o1.id.compareTo(o2.id) })

    init {
        addShopItem(
            CategoryModel(
                R.drawable.salary,
                "Поездка",
                Color.parseColor("#00B92D"),
                false
            )
        )
        updateLD()
        addShopItem(
            CategoryModel(
                R.drawable.salary,
                "Собака",
                Color.parseColor("#00B92D"),
                false
            )
        )
        updateLD()
        addShopItem(
            CategoryModel(
                R.drawable.settings_icon,
                "На себя",
                Color.parseColor("#00B92D"),
                false
            )
        )
        updateLD()
    }

    fun setSelectCategory(transaction: Transaction) {
        _transaction.value = transaction
    }

    fun isSelect(): Boolean? = categoryList.find { it.enable }?.enable

    fun getEnableCategory() = categoryList.find { it.enable }

    fun changeEnableState(categoryModelModule: CategoryModel) {
        if (!categoryModelModule.enable) {
            val oldItem = categoryList.find { it.enable }?.copy(enable = false)
            val newItem = categoryModelModule.copy(enable = !categoryModelModule.enable)
            editShopItem(newItem)
            oldItem?.let { editShopItem(it) }
        }
    }

    fun getDate() = System.currentTimeMillis()

    private fun addShopItem(item: CategoryModel) {
        if (item.id == CategoryModel.UNDEFINED_ID) {
            item.id = autoIncrementId++
        }
        categoryList.add(item)
        updateLD()
    }

    private fun editShopItem(shopItem: CategoryModel) {
        val oldItem = getShopItem(shopItem.id)
        categoryList.remove(oldItem)
        addShopItem(shopItem)
    }

    private fun getShopItem(shopItemId: Int): CategoryModel? {
        return categoryList.find {
            it.id == shopItemId
        }
    }

    private fun updateLD() {
        _listCategory.value = categoryList.toList()
    }
}
