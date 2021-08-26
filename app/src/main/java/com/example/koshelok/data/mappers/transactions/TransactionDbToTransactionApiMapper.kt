package com.example.koshelok.data.mappers.transactions

import com.example.koshelok.data.db.entity.TransactionDb
import com.example.koshelok.data.service.api.TransactionApi
import javax.inject.Inject

class TransactionDbToTransactionApiMapper @Inject constructor() :
        (TransactionDb) -> TransactionApi {

    override fun invoke(transaction: TransactionDb): TransactionApi {
        return TransactionApi(
            id = transaction.id,
            money = transaction.money,
            idCategory = transaction.idCategory,
            type = transaction.type,
            operation = transaction.operation,
            idIcon = transaction.idIcon,
            color = transaction.color,
            currency = transaction.currency,
            time = transaction.time
        )
    }
}
