package com.example.koshelok.domain.usecase

import com.example.koshelok.domain.Response
import com.example.koshelok.domain.repository.ActionTransactionRepository
import com.example.koshelok.ui.entity.TransactionEntity
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

interface EditTransactionUseCase {
    operator fun invoke(transactionEntity: TransactionEntity): Single<Response>
}

class EditTransactionUseCaseImpl @Inject constructor(
    private val actionTransactionRepository: ActionTransactionRepository
) : EditTransactionUseCase {

    override fun invoke(transactionEntity: TransactionEntity): Single<Response> {
        return actionTransactionRepository.editTransaction(transactionEntity)
    }
}
