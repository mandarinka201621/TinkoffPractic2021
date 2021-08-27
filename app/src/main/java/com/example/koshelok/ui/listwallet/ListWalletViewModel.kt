package com.example.koshelok.ui.listwallet

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.koshelok.data.AccountSharedPreferences
import com.example.koshelok.domain.LoadState
import com.example.koshelok.domain.repository.DeleteWalletRepository
import com.example.koshelok.domain.usecase.MainScreenUseCase
import com.example.koshelok.ui.listwallet.entity.MainScreenDataEntity
import com.example.koshelok.ui.main.RxViewModel
import com.example.koshelok.ui.util.ErrorHandler
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class ListWalletViewModel @Inject constructor(
    private val mainScreenUseCase: MainScreenUseCase,
    private val deleteWalletRepository: DeleteWalletRepository,
    private val accountSharedPreferences: AccountSharedPreferences,
    private val errorHandler: ErrorHandler
) : RxViewModel() {

    val errorData: LiveData<Throwable>
        get() = _errorData
    val loadStateData: LiveData<LoadState>
        get() = _loadStateData
    val mainScreenData: LiveData<MainScreenDataEntity>
        get() = _mainScreenData
    private val _errorData = MutableLiveData<Throwable>()
    private val _mainScreenData = MutableLiveData<MainScreenDataEntity>()
    private val _loadStateData = MutableLiveData<LoadState>()

    fun loadMainScreenData() {
        mainScreenUseCase(accountSharedPreferences.personId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { mainScreenData ->
                    _mainScreenData.value = mainScreenData
                },
                { error ->
                    errorHandler.createErrorToastBar(error)
                    _errorData.value = error
                }
            )
            .disposeOnFinish()
    }

    fun deleteWallet(walletId: Long) {
        deleteWalletRepository.deleteWallet(walletId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                _loadStateData.value = LoadState.SUCCESS
            }, {
                errorHandler.createErrorToastBar(it)
                _errorData.value = it
            })
            .disposeOnFinish()
    }
}
