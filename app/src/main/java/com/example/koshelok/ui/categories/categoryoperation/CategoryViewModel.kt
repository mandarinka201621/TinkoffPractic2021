package com.example.koshelok.ui.categories.categoryoperation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.koshelok.data.AccountSharedPreferences
import com.example.koshelok.data.mappers.category.CategoryToCategoryEntityMapper
import com.example.koshelok.domain.usecase.LoadCategoriesUseCase
import com.example.koshelok.ui.main.RxViewModel
import com.example.koshelok.ui.util.entity.CategoryEntity
import com.example.koshelok.ui.util.entity.TransactionEntity
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class CategoryViewModel @Inject constructor(
    private val loadCategoriesUseCase: LoadCategoriesUseCase,
    private val categoryMapper: CategoryToCategoryEntityMapper,
    private val accountSharedPreferences: AccountSharedPreferences
) : RxViewModel() {

    val errorData: LiveData<Throwable>
        get() = _errorData

    val listCategoryModel = MutableLiveData<List<CategoryEntity>>()
    private val _errorData = MutableLiveData<Throwable>()

    private val transactionLiveData = MutableLiveData<TransactionEntity>()
    private val categoryListValue: List<CategoryEntity>
        get() = requireNotNull(listCategoryModel.value)

    fun loadCategories(type: Int) {
        loadCategoriesUseCase(accountSharedPreferences.personId, type)
            .map { categories ->
                categories.map(categoryMapper)
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { categories ->
                    listCategoryModel.value = categories
                },
                {
                    _errorData.value = it
                }
            )
            .disposeOnFinish()
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
}
