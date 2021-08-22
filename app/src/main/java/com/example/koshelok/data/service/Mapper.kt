package com.example.koshelok.data.service

import com.example.koshelok.data.factory.IconFactory
import com.example.koshelok.data.service.api.CategoryApi
import com.example.koshelok.data.service.api.TransactionApi
import com.example.koshelok.data.service.api.WalletApi
import com.example.koshelok.domain.Category
import com.example.koshelok.extentions.getDate
import com.example.koshelok.extentions.getTime
import com.example.koshelok.ui.detailwallet.DetailWalletItem
import com.example.koshelok.ui.typeoperation.TypeOperationViewModel
import javax.inject.Inject

class Mapper @Inject constructor(private val iconFactory: IconFactory) {

    private fun mapIntToTypeCategory(type: Int): TypeOperationViewModel.Select {
        return when (type) {
            0 -> TypeOperationViewModel.Select.SELECT_EXPENSE
            1 -> TypeOperationViewModel.Select.SELECT_INCOME
            else -> throw NullPointerException("error type")
        }
    }

    fun mapCategoryToCategoryApi(category: Category) =
        CategoryApi(
            id = category.id,
            type = category.type.code,
            operation = category.operation,
            idIcon = iconFactory.convertDrawableIdToNumber(category.iconId),
            color = category.color
        )

    fun mapCategoryApiToCategory(categoryApi: CategoryApi) =
        Category(
            id = categoryApi.id,
            type = mapIntToTypeCategory(categoryApi.type),
            operation = categoryApi.operation,
            iconId = iconFactory.convertNumberToDrawableId(categoryApi.idIcon),
            color = categoryApi.color
        )

    fun mapWalletApiToHeaderWallet(walletApi: WalletApi) =
        DetailWalletItem.HeaderDetailWallet(
            nameWallet = walletApi.name,
            amountMoney = walletApi.amountMoney,
            income = walletApi.income,
            consumption = walletApi.expense,
            limit = walletApi.limit,
            currency = walletApi.currency
        )

    fun mapTransactionApiToDetailWalletTransaction(transaction: TransactionApi) =
        DetailWalletItem.Transaction(
            id = transaction.id,
            category = Category(
                id = transaction.idCategory,
                type = mapIntToTypeCategory(transaction.type),
                operation = transaction.operation,
                iconId = transaction.idIcon,
                color = transaction.color
            ),
            money = transaction.money,
            time = transaction.time.getTime(),
            day = transaction.time.getDate(),
            currency = transaction.currency
        )
}
