package com.example.koshelok.data.service

import com.example.koshelok.data.extentions.getDate
import com.example.koshelok.data.extentions.getTime
import com.example.koshelok.data.factory.IconFactory
import com.example.koshelok.data.service.api.BalanceApi
import com.example.koshelok.data.service.api.CategoryApi
import com.example.koshelok.data.service.api.CreateTransactionApi
import com.example.koshelok.data.service.api.ExchangeRatesApi
import com.example.koshelok.data.service.api.TransactionApi
import com.example.koshelok.data.service.api.WalletApi
import com.example.koshelok.domain.Category
import com.example.koshelok.domain.Currency
import com.example.koshelok.domain.TypeOperation
import com.example.koshelok.ui.detailwallet.DetailWalletItem
import com.example.koshelok.ui.listwallet.entity.BalanceEntity
import com.example.koshelok.ui.listwallet.entity.ExchangeRatesEntity
import com.example.koshelok.ui.listwallet.entity.WalletEntity
import com.example.koshelok.ui.model.Transaction
import java.util.*
import javax.inject.Inject

class Mapper @Inject constructor(private val iconFactory: IconFactory) {

    private fun mapIntToTypeCategory(type: Int): TypeOperation {
        return when (type) {
            0 -> TypeOperation.SELECT_EXPENSE
            1 -> TypeOperation.SELECT_INCOME
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
                iconId = iconFactory.convertNumberToDrawableId(transaction.idIcon),
                color = transaction.color
            ),
            money = transaction.money,
            time = transaction.time.getTime(),
            day = transaction.time.getDate(),
            currency = Currency.valueOf(transaction.currency)
        )

    fun mapTransactionToTransactionApi(transaction: Transaction) =
        CreateTransactionApi(
            idWallet = transaction.idWallet,
            money = transaction.sum?:"0",
            idCategory = transaction.categoryModel?.id?:0,
            time = transaction.date?:Calendar.getInstance().timeInMillis,
            currency = transaction.currency.name
        )

    fun mapExchangeRatesApiToExchangeRatesEntity(exchangeRatesApi: ExchangeRatesApi) =
        ExchangeRatesEntity(
            firstCurrency = Currency.valueOf(exchangeRatesApi.firstCurrency),
            firstCourse = exchangeRatesApi.firstCourse,
            firstIsUp = exchangeRatesApi.firstIsUp,
            secondCurrency = Currency.valueOf(exchangeRatesApi.secondCurrency),
            secondCourse = exchangeRatesApi.secondCourse,
            secondIsUp = exchangeRatesApi.secondIsUp,
            thirdCurrency = Currency.valueOf(exchangeRatesApi.thirdCurrency),
            thirdCourse = exchangeRatesApi.thirdCourse,
            thirdIsUp = exchangeRatesApi.thirdIsUp
        )

    fun mapBalanceApiToBalanceEntity(balanceApi: BalanceApi) =
        BalanceEntity(
            amountMoney = balanceApi.amountMoney,
            incomeMoney = balanceApi.incomeMoney,
            consumptionMoney = balanceApi.consumptionMoney
        )

    fun mapWalletApiToWalletEntity(walletApi: WalletApi) =
        WalletEntity(
            id = walletApi.id,
            name = walletApi.name,
            amountMoney = walletApi.amountMoney,
            currency = Currency.valueOf(walletApi.currency),
            isHide = walletApi.isHide
        )
}
