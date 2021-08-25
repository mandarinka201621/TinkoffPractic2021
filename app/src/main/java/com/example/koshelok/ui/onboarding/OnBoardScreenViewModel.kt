package com.example.koshelok.ui.onboarding

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.koshelok.data.AccountSharedPreferences
import com.example.koshelok.domain.Result
import com.example.koshelok.domain.usecase.RegistrationUserUseCase
import com.example.koshelok.ui.main.RxViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class OnBoardScreenViewModel @Inject constructor(
    private val registrationUserUseCase: RegistrationUserUseCase,
    private val accountSharedPreferences: AccountSharedPreferences
) : RxViewModel() {

    val resultData: LiveData<Result>
        get() = _loadStateData

    private val _loadStateData = MutableLiveData<Result>()

    fun registrationUser(email: String) {
        registrationUserUseCase(email)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { personId ->
                    accountSharedPreferences.email = email
                    accountSharedPreferences.personId = personId
                    _loadStateData.value = Result.Success<Long>(personId)
                },
                { error ->
                    _loadStateData.value = Result.Error(error)
                }
            )
            .disposeOnFinish()
    }
}
