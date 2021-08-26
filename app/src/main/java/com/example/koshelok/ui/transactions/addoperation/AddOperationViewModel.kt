package com.example.koshelok.ui.transactions.addoperation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.koshelok.domain.LoadState
import com.example.koshelok.domain.usecase.CreateTransactionUseCase
import com.example.koshelok.domain.usecase.EditTransactionUseCase
import com.example.koshelok.ui.main.RxViewModel
import com.example.koshelok.ui.util.entity.TransactionEntity
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class AddOperationViewModel @Inject constructor(
    private val createTransactionUseCase: CreateTransactionUseCase,
    private val editTransactionUseCase: EditTransactionUseCase
) : RxViewModel() {

    val transactionEntity: LiveData<TransactionEntity>
        get() = _transaction
    val loadStateData: LiveData<LoadState>
        get() = _loadStateData
    val errorData: LiveData<Throwable>
        get() = _errorData

    private val _transaction = MutableLiveData<TransactionEntity>()
    private val _loadStateData = MutableLiveData<LoadState>()
    private val _errorData = MutableLiveData<Throwable>()

    fun setTransaction(transactionEntity: TransactionEntity) {
        _transaction.value = transactionEntity
    }

    fun createTransaction(transactionEntity: TransactionEntity) {
        createTransactionUseCase(transactionEntity)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                _loadStateData.value = LoadState.SUCCESS
            }, {
                _errorData.value = it
            })
            .disposeOnFinish()
    }

    fun editTransaction(transactionEntity: TransactionEntity) {
        editTransactionUseCase(transactionEntity)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                _loadStateData.value = LoadState.SUCCESS
            }, {
                _errorData.value = it
            })
            .disposeOnFinish()
    }
}
