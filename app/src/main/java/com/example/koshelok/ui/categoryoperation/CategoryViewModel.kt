package com.example.koshelok.ui.categoryoperation

import androidx.lifecycle.MutableLiveData
import com.example.koshelok.domain.usecase.LoadCategoriesUseCase
import com.example.koshelok.ui.RxViewModel
import com.example.koshelok.ui.entity.CategoryEntity
import com.example.koshelok.ui.entity.TransactionEntity
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class CategoryViewModel @Inject constructor(
    private val loadCategoriesUseCase: LoadCategoriesUseCase
) : RxViewModel() {

    val listCategoryModel = MutableLiveData<List<CategoryEntity>>()

    private val transactionLiveData = MutableLiveData<TransactionEntity>()

    private val categoryListValue: List<CategoryEntity>
        get() = requireNotNull(listCategoryModel.value)

    init {
        loadCategories()
    }

    private fun loadCategories() {
        loadCategoriesUseCase(0)
            .map { categories ->
                categories.map {
                    CategoryEntity(
                        id = it.id,
                        icon = it.iconId,
                        typeOperation = it.operation,
                        color = it.color,
                        isEnable = false,
                    )
                }
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { categories ->
                    listCategoryModel.value = categories
                },
                {
                    //TODO сделать обработчик ошибок
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
