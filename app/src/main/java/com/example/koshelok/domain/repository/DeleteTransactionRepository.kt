package com.example.koshelok.domain.repository

import com.example.koshelok.domain.Response
import io.reactivex.rxjava3.core.Single

interface DeleteTransactionRepository {

    fun deleteTransaction(transactionId: Long): Single<Response>
}
