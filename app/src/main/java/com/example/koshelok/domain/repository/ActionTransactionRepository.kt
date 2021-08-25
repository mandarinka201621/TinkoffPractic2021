package com.example.koshelok.domain.repository

import com.example.koshelok.ui.util.entity.TransactionEntity
import io.reactivex.rxjava3.core.Completable

interface ActionTransactionRepository {

    fun editTransaction(transactionEntity: TransactionEntity): Completable

    fun createTransaction(transactionEntity: TransactionEntity): Completable
}
