package com.example.koshelok.domain.repository

import com.example.koshelok.data.service.api.AnswerServerApi
import com.example.koshelok.ui.model.Transaction
import io.reactivex.rxjava3.core.Single

interface ActionTransactionRepository {

    fun editTransaction(transaction: Transaction): Single<AnswerServerApi>
}
