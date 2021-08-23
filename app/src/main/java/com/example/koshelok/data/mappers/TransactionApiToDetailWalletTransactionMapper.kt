package com.example.koshelok.data.mappers

import com.example.koshelok.data.IconConverter
import com.example.koshelok.data.extentions.getFormattedDate
import com.example.koshelok.data.extentions.getTime
import com.example.koshelok.data.service.api.TransactionApi
import com.example.koshelok.domain.Category
import com.example.koshelok.domain.Currency
import com.example.koshelok.ui.detailwallet.DetailWalletItem
import javax.inject.Inject

class TransactionApiToDetailWalletTransactionMapper @Inject constructor(
    private val intToTypeCategoryMapper: IntToTypeCategoryMapper,
    private val iconConverter: IconConverter
) {

    operator fun invoke(transaction: TransactionApi) =
        DetailWalletItem.Transaction(
            id = transaction.id,
            category = Category(
                id = transaction.idCategory,
                type = intToTypeCategoryMapper(transaction.type),
                operation = transaction.operation,
                iconId = iconConverter.convertNumberToDrawableId(transaction.idIcon),
                color = transaction.color
            ),
            money = transaction.money,
            time = transaction.time.getTime(),
            day = transaction.time.getFormattedDate(),
            currency = Currency.valueOf(transaction.currency)
        )
}
