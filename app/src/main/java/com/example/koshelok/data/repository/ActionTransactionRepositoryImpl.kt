package com.example.koshelok.data.repository

import com.example.koshelok.data.mappers.TransactionToTransactionApiMapper
import com.example.koshelok.data.service.AppService
import com.example.koshelok.domain.repository.ActionTransactionRepository
import com.example.koshelok.ui.entity.TransactionEntity
import io.reactivex.rxjava3.core.Completable
import javax.inject.Inject

class ActionTransactionRepositoryImpl @Inject constructor(
    private val mapper: TransactionToTransactionApiMapper,
    private val appService: AppService
) : ActionTransactionRepository {

    override fun editTransaction(transactionEntity: TransactionEntity): Completable {
        return appService.editTransaction(transactionEntity.id ?: 0, mapper(transactionEntity))
    }

    override fun createTransaction(transactionEntity: TransactionEntity): Completable {
        return appService.createTransaction(mapper(transactionEntity))
    }
}
