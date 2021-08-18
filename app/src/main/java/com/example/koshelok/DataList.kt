package com.example.koshelok

import com.example.koshelok.domain.Category
import com.example.koshelok.ui.detailwallet.DetailWalletItem

object DataList {
    val data = mutableListOf(
        DetailWalletItem.Transaction(
            category = Category.Income.Salary(),
            money = 2000,
            time = "15:41",
            day = "2021-08-19"
        ),
        DetailWalletItem.Transaction(
            category = Category.Income.PartTime(),
            money = 7000,
            time = "12:11",
            day = "2021-08-18"
        ),
        DetailWalletItem.Transaction(
            category = Category.Consumption.Jewelry(),
            money = 5000,
            time = "11:56",
            day = "2021-08-15"
        )
    )
}
