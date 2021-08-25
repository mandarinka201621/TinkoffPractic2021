package com.example.koshelok.ui.detailwallet

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.koshelok.domain.Result
import com.example.koshelok.domain.repository.DeleteTransactionRepository
import com.example.koshelok.domain.usecase.HeaderWalletUseCase
import com.example.koshelok.domain.usecase.TransactionsUseCase
import com.example.koshelok.ui.RxViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class DetailWalletViewModel @Inject constructor(
    private val transactionsUseCase: TransactionsUseCase,
    private val headerWalletUseCase: HeaderWalletUseCase,
    private val deleteTransactionRepository: DeleteTransactionRepository
) : RxViewModel() {

    val resultData: LiveData<Result>
        get() = _resultData
    val detailWalletData: LiveData<List<DetailWalletItem>>
        get() = _detailWalletData

    private val _resultData = MutableLiveData<Result>()
    private val _detailWalletData = MutableLiveData<List<DetailWalletItem>>()

    fun loadWalletData(walletId: Long) {
        Single.zip(
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
                //TODO сделать обработку ошибок
            })
            .disposeOnFinish()
    }

    fun deleteTransaction(transaction: DetailWalletItem.Transaction) {
        deleteTransactionRepository.deleteTransaction(transaction.id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                _resultData.value = Result.Success(Unit)
            }, {
                _resultData.value = Result.Error(it)
            })
            .disposeOnFinish()
    }
}
