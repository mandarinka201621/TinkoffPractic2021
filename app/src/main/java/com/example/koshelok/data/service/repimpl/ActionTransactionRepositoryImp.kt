package com.example.koshelok.data.service.repimpl

import com.example.koshelok.data.service.AppApi
import com.example.koshelok.data.service.Mapper
import com.example.koshelok.data.service.api.ResponseApi
import com.example.koshelok.domain.repository.ActionTransactionRepository
import com.example.koshelok.ui.model.Transaction
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class ActionTransactionRepositoryImp @Inject constructor(
    private val mapper: Mapper,
    private val appApi: AppApi
) : ActionTransactionRepository {

    override fun editTransaction(transaction: Transaction): Single<ResponseApi> {
        return Single.just(transaction)
            .map { mapper.mapTransactionToTransactionApi(it) }
            .flatMap {
                appApi.editTransaction(it)
            }
    }
}
