package com.example.koshelok.ui.editwallet

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.koshelok.domain.usecase.CreateWalletUseCase
import com.example.koshelok.ui.RxViewModel
import com.example.koshelok.ui.entity.CreateWalletEntity
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class EditWalletViewModel @Inject constructor(
    private val createWalletUseCase: CreateWalletUseCase
) : RxViewModel() {

    val responseServerData: LiveData<ResponseWithWalletEntity>
        get() = _responseServerData

    private val _responseServerData = MutableLiveData<ResponseWithWalletEntity>()

    fun createWallet(createWalletEntity: CreateWalletEntity) {
        createWalletUseCase(0, createWalletEntity)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { response ->
                    _responseServerData.value = response
                },
                {

                }
            )
            .disposeOnFinish()
    }
}
