package com.example.koshelok.data.repository

import com.example.koshelok.data.mapper.ResponseApiToResponseMapper
import com.example.koshelok.data.service.AppService
import com.example.koshelok.domain.Response
import com.example.koshelok.domain.repository.DeleteTransactionRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class DeleteTransactionRepositoryImpl @Inject constructor(
    private val appService: AppService,
    private val mapper: ResponseApiToResponseMapper
) :
    DeleteTransactionRepository {

    override fun deleteTransaction(transactionId: Long): Single<Response> {
        return appService.deleteTransaction(transactionId)
            .map {
                mapper(it)
            }
    }
}
