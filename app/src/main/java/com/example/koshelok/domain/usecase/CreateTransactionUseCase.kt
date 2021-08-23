package com.example.koshelok.domain.usecase

import com.example.koshelok.domain.Response
import com.example.koshelok.domain.repository.ActionTransactionRepository
import com.example.koshelok.ui.entity.TransactionEntity
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

interface CreateTransactionUseCase {

    operator fun invoke(transactionEntity: TransactionEntity): Single<Response>
}

class CreateTransactionUseCaseImpl @Inject constructor(
    private val actionTransactionRepository: ActionTransactionRepository
) : CreateTransactionUseCase {

    override fun invoke(transactionEntity: TransactionEntity): Single<Response> {
        return actionTransactionRepository.createTransaction(transactionEntity)
    }
}
