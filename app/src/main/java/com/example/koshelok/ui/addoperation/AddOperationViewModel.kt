package com.example.koshelok.ui.addoperation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.koshelok.domain.Result
import com.example.koshelok.domain.usecase.CreateTransactionUseCase
import com.example.koshelok.domain.usecase.EditTransactionUseCase
import com.example.koshelok.ui.RxViewModel
import com.example.koshelok.ui.entity.TransactionEntity
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class AddOperationViewModel @Inject constructor(
    private val createTransactionUseCase: CreateTransactionUseCase,
    private val editTransactionUseCase: EditTransactionUseCase
) : RxViewModel() {

    val transactionEntity: LiveData<TransactionEntity>
        get() = _transaction
    val responseServerData: LiveData<Result>
        get() = _responseServerData

    private val _transaction = MutableLiveData<TransactionEntity>()
    private val _responseServerData = MutableLiveData<Result>()

    fun setTransaction(transactionEntity: TransactionEntity) {
        _transaction.value = transactionEntity
    }

    fun createTransaction(transactionEntity: TransactionEntity) {
        createTransactionUseCase(transactionEntity)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                _responseServerData.value = Result.Success(Unit)
            }, {
                _responseServerData.value = Result.Error(it)
            })
            .disposeOnFinish()
    }

    fun editTransaction(transactionEntity: TransactionEntity) {
        editTransactionUseCase(transactionEntity)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                _responseServerData.value = Result.Success(Unit)
            }, {
                _responseServerData.value = Result.Error(it)
            })
            .disposeOnFinish()
    }
}
