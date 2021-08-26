package com.example.koshelok.data.mappers.transactions

import com.example.koshelok.data.db.entity.TransactionDb
import com.example.koshelok.data.service.api.TransactionApi
import javax.inject.Inject

class TransactionsApiToTransactionsDbMapper @Inject constructor() :
        (TransactionApi, Long) -> TransactionDb {
    override operator fun invoke(transaction: TransactionApi, walletId: Long): TransactionDb {
        return TransactionDb(
            id = transaction.id,
            money = transaction.money,
            idCategory = transaction.idCategory,
            type = transaction.type,
            operation = transaction.operation,
            idIcon = transaction.idIcon,
            color = transaction.color,
            currency = transaction.currency,
            time = transaction.time,
            walletId = walletId
        )
    }
}
