package com.example.koshelok.data.repository

import com.example.koshelok.data.mappers.ResponseApiToResponseMapper
import com.example.koshelok.data.mappers.TransactionToTransactionApiMapper
import com.example.koshelok.data.service.AppService
import com.example.koshelok.domain.Response
import com.example.koshelok.domain.repository.ActionTransactionRepository
import com.example.koshelok.ui.entity.TransactionEntity
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class ActionTransactionRepositoryImpl @Inject constructor(
    private val mapper: TransactionToTransactionApiMapper,
    private val responseMapper: ResponseApiToResponseMapper,
    private val appService: AppService
) : ActionTransactionRepository {

    override fun editTransaction(transactionEntity: TransactionEntity): Single<Response> {
        return appService.editTransaction(transactionEntity.id ?: 0, mapper(transactionEntity))
            .map {
                responseMapper(it)
            }
    }

    override fun createTransaction(transactionEntity: TransactionEntity): Single<Response> {
        return appService.createTransaction(mapper(transactionEntity))
            .map {
                responseMapper(it)
            }
    }
}
