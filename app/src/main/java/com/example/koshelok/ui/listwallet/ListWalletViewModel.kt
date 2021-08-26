package com.example.koshelok.ui.listwallet

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.koshelok.data.AccountSharedPreferences
import com.example.koshelok.domain.usecase.MainScreenUseCase
import com.example.koshelok.ui.listwallet.entity.MainScreenDataEntity
import com.example.koshelok.ui.main.RxViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class ListWalletViewModel @Inject constructor(
    private val mainScreenUseCase: MainScreenUseCase,
    private val accountSharedPreferences: AccountSharedPreferences
) : RxViewModel() {

    val errorData: LiveData<Throwable>
        get() = _errorData
    val mainScreenData: LiveData<MainScreenDataEntity>
        get() = _mainScreenData
    private val _mainScreenData = MutableLiveData<MainScreenDataEntity>()
    private val _errorData = MutableLiveData<Throwable>()

    fun loadMainScreenData() {
        mainScreenUseCase(accountSharedPreferences.personId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { mainScreenData ->
                    _mainScreenData.value = mainScreenData
                },
                { error ->
                    _errorData.value = error
                }
            )
            .disposeOnFinish()
    }

}
