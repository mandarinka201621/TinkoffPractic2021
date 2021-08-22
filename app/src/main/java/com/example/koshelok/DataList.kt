package com.example.koshelok

import android.graphics.Color
import com.example.koshelok.domain.Category
import com.example.koshelok.ui.detailwallet.DetailWalletItem
import com.example.koshelok.ui.typeoperation.TypeOperationViewModel

object DataList {
    val data = mutableListOf(
        DetailWalletItem.Transaction(
            id = 98,
            category = Category(
                0,
                TypeOperationViewModel.Select.SELECT_INCOME,
                "Зарплата",
                R.drawable.salary,
                Color.parseColor("#00B92D")
            ),
            money = "2 000 ₽",
            time = "15:41",
            day = "2021-08-19",
            currency = "rub"
        ),
        DetailWalletItem.Transaction(
            id = 99,
            category  = Category(
                0,
                TypeOperationViewModel.Select.SELECT_INCOME,
                "Зарплата 1",
                R.drawable.salary,
                Color.parseColor("#00B92D")
            ),
            money = "7 000 ₽",
            time = "12:11",
            day = "2021-08-18",
            currency = "rub"
        ),
        DetailWalletItem.Transaction(
            id = 100,
            category = Category(
                1,
                TypeOperationViewModel.Select.SELECT_INCOME,
                "Зарплата2",
                R.drawable.salary,
                Color.parseColor("#00B92D")
            ),
            money = "-5 000 ₽",
            time = "11:56",
            day = "2021-08-15",
            currency = "rub"
        )
    )
}
