package com.example.koshelok.data.repository

import com.example.koshelok.data.mappers.TransactionToTransactionApiMapper
import com.example.koshelok.data.service.AppService
import com.example.koshelok.data.service.api.ResponseApi
import com.example.koshelok.domain.repository.ActionTransactionRepository
import com.example.koshelok.ui.model.Transaction
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class ActionTransactionRepositoryImpl @Inject constructor(
    private val mapper: TransactionToTransactionApiMapper,
    private val appService: AppService
) : ActionTransactionRepository {

    override fun editTransaction(transaction: Transaction): Single<ResponseApi> {
        return Single.just(transaction)
            .map { mapper(it) }
            .flatMap {
                appService.editTransaction(it)
            }
    }
}
