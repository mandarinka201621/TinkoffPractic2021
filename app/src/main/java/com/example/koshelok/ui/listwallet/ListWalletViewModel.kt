package com.example.koshelok.ui.listwallet

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.koshelok.domain.Result
import com.example.koshelok.domain.usecase.MainScreenUseCase
import com.example.koshelok.ui.listwallet.entity.MainScreenDataEntity
import com.example.koshelok.ui.main.RxViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class ListWalletViewModel @Inject constructor(
    private val mainScreenUseCase: MainScreenUseCase,
) : RxViewModel() {

    val resultData: LiveData<Result>
        get() = _loadStateData
    private val _loadStateData = MutableLiveData<Result>()

    fun loadMainScreenData(personId: Long) {
        mainScreenUseCase(personId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { mainScreenData ->
                    _loadStateData.value = Result.Success<MainScreenDataEntity>(mainScreenData)
                },
                { error ->
                    _loadStateData.value = Result.Error(error)
                }
            )
            .disposeOnFinish()
    }

}
