package com.example.koshelok

import android.graphics.Color
import com.example.koshelok.domain.Category
import com.example.koshelok.ui.detailwallet.DetailWalletItem

object DataList {
    val data = mutableListOf(
        DetailWalletItem.Transaction(
            category = Category.Income(
                typeOperation = "Зарплата",
                icon = R.drawable.salary,
                color = Color.parseColor("#00B92D")
            ),
            money = "2000",
            time = "15:41",
            day = "2021-08-19"
        ),
        DetailWalletItem.Transaction(
            category = Category.Income(
                typeOperation = "Частичная работа",
                icon = R.drawable.salary,
                color = Color.parseColor("#00B92D")
            ),
            money = "7000",
            time = "12:11",
            day = "2021-08-18"
        ),
        DetailWalletItem.Transaction(
            category = Category.Consumption(
                typeOperation = "Украшения",
                icon = R.drawable.jewelry,
                color = Color.parseColor("#5833ee")
            ),
            money = "5000",
            time = "11:56",
            day = "2021-08-15"
        )
    )
}
