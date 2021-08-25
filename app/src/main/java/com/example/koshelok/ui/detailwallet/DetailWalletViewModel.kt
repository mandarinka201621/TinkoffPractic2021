package com.example.koshelok.ui.detailwallet

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.koshelok.domain.LoadState
import com.example.koshelok.domain.repository.DeleteTransactionRepository
import com.example.koshelok.domain.usecase.HeaderWalletUseCase
import com.example.koshelok.domain.usecase.TransactionsUseCase
import com.example.koshelok.ui.main.RxViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class DetailWalletViewModel @Inject constructor(
    private val transactionsUseCase: TransactionsUseCase,
    private val headerWalletUseCase: HeaderWalletUseCase,
    private val deleteTransactionRepository: DeleteTransactionRepository
) : RxViewModel() {

    val detailWalletData: LiveData<List<DetailWalletItem>>
        get() = _detailWalletData
    val errorData: LiveData<Throwable>
        get() = _errorData
    val loadStateData: LiveData<LoadState>
        get() = _loadStateData

    private val _detailWalletData = MutableLiveData<List<DetailWalletItem>>()
    private val _errorData = MutableLiveData<Throwable>()
    private val _loadStateData = MutableLiveData<LoadState>()

    fun loadWalletData(walletId: Long) {
        Observable.zip(
            headerWalletUseCase(walletId).subscribeOn(Schedulers.io()),
            transactionsUseCase(walletId).subscribeOn(Schedulers.io())
        )
        { wallet, transactions ->
            return@zip mutableListOf<DetailWalletItem>(wallet).apply {
                addAll(transactions.reversed())
            }.toList()
        }.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ detailWalletsItems ->
                _detailWalletData.value = detailWalletsItems
            }, {
                _errorData.value = it
            })
            .disposeOnFinish()
    }

    fun deleteTransaction(transaction: DetailWalletItem.Transaction) {
        deleteTransactionRepository.deleteTransaction(transaction.id)
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
