package com.example.koshelok.domain.repository

import io.reactivex.rxjava3.core.Completable

interface DeleteTransactionRepository {

    fun deleteTransaction(transactionId: Long): Completable
}
