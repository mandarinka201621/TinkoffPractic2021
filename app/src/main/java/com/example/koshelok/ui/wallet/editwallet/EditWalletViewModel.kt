package com.example.koshelok.ui.wallet.editwallet

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.koshelok.data.AccountSharedPreferences
import com.example.koshelok.domain.usecase.CreateWalletUseCase
import com.example.koshelok.ui.main.RxViewModel
import com.example.koshelok.ui.util.entity.CreateWalletEntity
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class EditWalletViewModel @Inject constructor(
    private val createWalletUseCase: CreateWalletUseCase,
    private val accountSharedPreferences: AccountSharedPreferences
) : RxViewModel() {

    val walletIdData: LiveData<Long>
        get() = _walletIdData
    val errorData: LiveData<Throwable>
        get() = _errorData
    private val _walletIdData = MutableLiveData<Long>()
    private val _errorData = MutableLiveData<Throwable>()

    fun createWallet(createWalletEntity: CreateWalletEntity) {
        createWalletUseCase(accountSharedPreferences.personId, createWalletEntity)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { walletId ->
                    _walletIdData.value = walletId
                },
                {
                    _errorData.value = it
                }
            )
            .disposeOnFinish()
    }
}
