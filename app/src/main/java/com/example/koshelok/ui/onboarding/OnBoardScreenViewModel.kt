package com.example.koshelok.ui.onboarding

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.koshelok.data.AccountSharedPreferences
import com.example.koshelok.domain.LoadState
import com.example.koshelok.domain.usecase.RegistrationUserUseCase
import com.example.koshelok.ui.main.RxViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class OnBoardScreenViewModel @Inject constructor(
    private val registrationUserUseCase: RegistrationUserUseCase,
    private val accountSharedPreferences: AccountSharedPreferences
) : RxViewModel() {


    val loadStateData: LiveData<LoadState>
        get() = _loadStateData
    val errorData: LiveData<Throwable>
        get() = _errorData

    private val _errorData = MutableLiveData<Throwable>()
    private val _loadStateData = MutableLiveData<LoadState>()

    fun registrationUser(userEntity: UserEntity) {
        registrationUserUseCase(userEntity)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { personId ->
                    accountSharedPreferences.email = userEntity.email
                    accountSharedPreferences.personId = personId
                    _loadStateData.value = LoadState.SUCCESS
                },
                { error ->
                    _errorData.value = error
                }
            )
            .disposeOnFinish()
    }
}
