package com.example.koshelok.data.mappers

import com.example.koshelok.data.service.api.CreateTransactionApi
import com.example.koshelok.ui.model.Transaction
import java.util.*
import javax.inject.Inject

class TransactionToTransactionApiMapper @Inject constructor() {

    operator fun invoke(transaction: Transaction) =
        CreateTransactionApi(
            idWallet = transaction.idWallet,
            money = transaction.sum ?: "0",
            idCategory = transaction.categoryModel?.id ?: 0,
            time = transaction.date ?: Calendar.getInstance().timeInMillis,
            currency = transaction.currency.name
        )
}
