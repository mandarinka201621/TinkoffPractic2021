package com.example.koshelok.ui.categories.createcategory

import android.graphics.Color
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.koshelok.data.AccountSharedPreferences
import com.example.koshelok.domain.Category
import com.example.koshelok.domain.Result
import com.example.koshelok.domain.usecase.CreateCategoryUseCase
import com.example.koshelok.ui.util.IconConverter
import com.example.koshelok.ui.util.entity.IconEntity
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class CreateCategoryViewModel @Inject constructor(
    private val createCategoryUseCase: CreateCategoryUseCase,
    private val accountSharedPreferences: AccountSharedPreferences
) : ViewModel() {

    val listIconModel = MutableLiveData<List<IconEntity>>()
    val enableColor = MutableLiveData<Int>()
    val resultData = MutableLiveData<Result>()

    private val iconListValue: List<IconEntity>
        get() = requireNotNull(listIconModel.value)

    init {
        val listIcon = mutableListOf<IconEntity>()
        for (iconId in 0..COUNT_ICONS) {
            listIcon.add(
                IconEntity(
                    iconId,
                    IconConverter().convertNumberToDrawableId(iconId),
                    Color.parseColor("#5833EE"),
                    false
                )
            )
        }
        listIconModel.value = listIcon
    }

    fun createCategory(category: Category) {
        createCategoryUseCase(accountSharedPreferences.personId, category)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    resultData.value = Result.Success(Unit)
                },
                {
                    resultData.value = Result.Error(it)
                }
            )
    }

    fun isSelect(): Boolean = iconListValue.any { it.isEnable }

    fun getEnableIcon() = iconListValue.find { it.isEnable }

    fun setEnableColor(color: Int) {
        enableColor.value = color
    }

    fun changeEnableState(position: Int, iconEntity: IconEntity) {
        if (!iconEntity.isEnable) {
            getEnableIcon()?.isEnable = false
            iconListValue[position].isEnable = true
            updateLD()
        }
    }

    private fun updateLD() {
        listIconModel.value = listIconModel.value
    }

    companion object {
        private const val COUNT_ICONS = 29
    }
}
