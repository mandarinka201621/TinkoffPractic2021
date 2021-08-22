package com.example.koshelok

import android.graphics.Color
import com.example.koshelok.domain.Category
import com.example.koshelok.domain.Currency
import com.example.koshelok.domain.TypeOperation
import com.example.koshelok.ui.detailwallet.DetailWalletItem

object DataList {
    val data = mutableListOf(
        DetailWalletItem.Transaction(
            id = 98,
            category = Category(
                0,
                TypeOperation.SELECT_INCOME,
                "Зарплата",
                R.drawable.salary,
                Color.parseColor("#00B92D")
            ),
            money = "2 000 ₽",
            time = "15:41",
            day = "2021-08-19",
            currency = Currency.RUB
        ),
        DetailWalletItem.Transaction(
            id = 99,
            category  = Category(
                0,
                TypeOperation.SELECT_INCOME,
                "Зарплата 1",
                R.drawable.salary,
                Color.parseColor("#00B92D")
            ),
            money = "7 000 ₽",
            time = "12:11",
            day = "2021-08-18",
            currency =Currency.RUB
        ),
        DetailWalletItem.Transaction(
            id = 100,
            category = Category(
                1,
                TypeOperation.SELECT_INCOME,
                "Зарплата2",
                R.drawable.salary,
                Color.parseColor("#00B92D")
            ),
            money = "-5 000 ₽",
            time = "11:56",
            day = "2021-08-15",
            currency = Currency.RUB
        )
    )
}
