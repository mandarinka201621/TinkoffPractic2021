package com.example.koshelok.data.service.repimpl

import com.example.koshelok.data.service.AppApi
import com.example.koshelok.data.service.Mapper
import com.example.koshelok.domain.Response
import com.example.koshelok.domain.repository.DeleteTransactionRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class DeleteTransactionRepositoryImpl @Inject constructor(
    private val appApi: AppApi,
    private val mapper: Mapper
) :
    DeleteTransactionRepository {

    override fun deleteTransaction(transactionId: Long): Single<Response> {
        return appApi.deleteTransaction(transactionId)
            .map {
                mapper.mapResponseApiToResponse(it)
            }
    }
}
