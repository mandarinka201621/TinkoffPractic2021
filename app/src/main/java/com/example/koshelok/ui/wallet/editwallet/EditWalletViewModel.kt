package com.example.koshelok.ui.wallet.editwallet

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.koshelok.domain.Result
import com.example.koshelok.domain.usecase.CreateWalletUseCase
import com.example.koshelok.ui.main.RxViewModel
import com.example.koshelok.ui.util.entity.CreateWalletEntity
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class EditWalletViewModel @Inject constructor(
    private val createWalletUseCase: CreateWalletUseCase
) : RxViewModel() {

    val responseServerData: LiveData<Result>
        get() = _responseServerData

    private val _responseServerData = MutableLiveData<Result>()

    fun createWallet(createWalletEntity: CreateWalletEntity) {
        createWalletUseCase(0, createWalletEntity)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { walletId ->
                    _responseServerData.value = Result.Success<Long>(walletId)
                },
                {
                    _responseServerData.value = Result.Error(it)
                }
            )
            .disposeOnFinish()
    }
}
