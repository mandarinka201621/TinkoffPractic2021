package com.example.koshelok.data.service.repimpl

import com.example.koshelok.data.service.AppApi
import com.example.koshelok.data.service.api.AnswerServerApi
import com.example.koshelok.domain.repository.DeleteTransactionRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class DeleteTransactionRepositoryImpl @Inject constructor(
    private val appApi: AppApi
) :
    DeleteTransactionRepository {

    override fun deleteTransaction(transactionId: Long): Single<AnswerServerApi> {
        return appApi.deleteTransaction(transactionId)
    }
}
