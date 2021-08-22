package com.example.koshelok.ui.detailwallet

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.koshelok.DataList
import com.example.koshelok.domain.Response
import com.example.koshelok.domain.repository.DeleteTransactionRepository
import com.example.koshelok.domain.usecase.DetailWalletUseCase
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class DetailWalletViewModel @Inject constructor(
    private val detailWalletUseCase: DetailWalletUseCase,
    private val deleteTransactionRepository: DeleteTransactionRepository
) : ViewModel() {

    val detailWalletData = MutableLiveData<List<DetailWalletItem>>()
    val responseData = MutableLiveData<Response>()

    fun uploadData(walletId: Long): List<DetailWalletItem> {
        detailWalletUseCase(walletId).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {  detailWalletsItems ->
                detailWalletData.value = detailWalletsItems
            }
        return DataList.data
    }

    fun getData(): LiveData<List<DetailWalletItem>> {
        return detailWalletData
    }

    fun deleteTransaction(transaction: DetailWalletItem.Transaction) {
        deleteTransactionRepository.deleteTransaction(transaction.id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { response ->

            }
    }
}
