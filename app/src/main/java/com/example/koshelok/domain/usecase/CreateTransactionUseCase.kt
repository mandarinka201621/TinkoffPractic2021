package com.example.koshelok.domain.usecase

import com.example.koshelok.domain.repository.ActionTransactionRepository
import com.example.koshelok.ui.util.entity.TransactionEntity
import io.reactivex.rxjava3.core.Completable
import javax.inject.Inject

interface CreateTransactionUseCase {

    operator fun invoke(transactionEntity: TransactionEntity): Completable
}

class CreateTransactionUseCaseImpl @Inject constructor(
    private val actionTransactionRepository: ActionTransactionRepository
) : CreateTransactionUseCase {

    override fun invoke(transactionEntity: TransactionEntity): Completable {
        return actionTransactionRepository.createTransaction(transactionEntity)
    }
}
