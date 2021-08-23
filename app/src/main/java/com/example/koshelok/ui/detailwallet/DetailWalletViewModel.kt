package com.example.koshelok.ui.detailwallet

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.koshelok.domain.Response
import com.example.koshelok.domain.repository.DeleteTransactionRepository
import com.example.koshelok.domain.usecase.HeaderWalletUseCase
import com.example.koshelok.domain.usecase.TransactionsUseCase
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class DetailWalletViewModel @Inject constructor(
    private val transactionsUseCase: TransactionsUseCase,
    private val headerWalletUseCase: HeaderWalletUseCase,
    private val deleteTransactionRepository: DeleteTransactionRepository
) : ViewModel() {

    val detailWalletData: LiveData<List<DetailWalletItem>>
        get() = _detailWalletData
    val responseData: LiveData<Response>
        get() = _responseData

    private val _detailWalletData = MutableLiveData<List<DetailWalletItem>>()
    private val _responseData = MutableLiveData<Response>()

    fun uploadData(walletId: Long) {
        Single.zip(headerWalletUseCase(walletId), transactionsUseCase(walletId)) { wallet, transactions ->
            return@zip mutableListOf<DetailWalletItem>(wallet).apply {
                addAll(transactions.reversed())
            }.toList()
        }.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { detailWalletsItems ->
                _detailWalletData.value = detailWalletsItems
            }
    }

    fun deleteTransaction(transaction: DetailWalletItem.Transaction) {
        deleteTransactionRepository.deleteTransaction(transaction.id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { response ->
                _responseData.value = response
            }
    }
}
