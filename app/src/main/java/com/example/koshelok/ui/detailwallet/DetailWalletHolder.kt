package com.example.koshelok.ui.detailwallet

import android.content.res.ColorStateList
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.koshelok.R
import com.example.koshelok.databinding.ItemDayBinding
import com.example.koshelok.databinding.ItemHeaderDetailWalletBinding
import com.example.koshelok.databinding.ItemTransactionBinding
import com.example.koshelok.domain.Category
import kotlinx.datetime.Clock
import kotlinx.datetime.DatePeriod
import kotlinx.datetime.LocalDate
import kotlinx.datetime.TimeZone
import kotlinx.datetime.minus
import kotlinx.datetime.toLocalDate
import kotlinx.datetime.toLocalDateTime

class HeaderHolder(view: View) : BaseHolder(view) {

    private val binding by viewBinding(ItemHeaderDetailWalletBinding::bind)

    override fun onBind(data: DetailWalletItem) {
        if (data is DetailWalletItem.HeaderDetailWallet) {
            with(binding) {
                amountMoney.text =
                    root.context.getString(R.string.income_money, data.amountMoney.toString())
                income.text = root.context.getString(R.string.income_money, data.income.toString())
                consumption.text =
                    root.context.getString(R.string.income_money, data.consumption.toString())
                limit.text = root.context.getString(R.string.limit_money, data.limit.toString())
            }
        }
    }
}

class DayHolder(view: View) : BaseHolder(view) {

    private val binding by viewBinding(ItemDayBinding::bind)

    override fun onBind(data: DetailWalletItem) {
        if (data is DetailWalletItem.Day) {
            binding.day.text = checkData(data.day)
        }
    }

    private fun checkData(day: String): String {
        val localDay = day.toLocalDate()
        val currentTime = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault())
        val currentDate =
            LocalDate(currentTime.year, currentTime.monthNumber, currentTime.dayOfMonth)
        return when (currentDate.minus(localDay)) {
            DatePeriod(0, 0, 0) -> binding.root.context.getString(R.string.today)
            DatePeriod(0, 0, 1) -> binding.root.context.getString(R.string.yesterday)
            else -> "${localDay.dayOfMonth}.${localDay.monthNumber}"
        }
    }
}

class TransactionHolder(view: View) : BaseHolder(view) {

    private val binding by viewBinding(ItemTransactionBinding::bind)

    override fun onBind(data: DetailWalletItem) {
        if (data is DetailWalletItem.Transaction) {
            with(binding) {
                icon.setImageDrawable(ContextCompat.getDrawable(root.context, data.category.icon))
                icon.backgroundTintList = ColorStateList.valueOf(data.category.color)
                typeOperation.text = data.category.typeOperation
                val moneyText: String
                val category: String
                if (data.category is Category.Income) {
                    moneyText = root.context.getString(R.string.income_money, data.money.toString())
                    category = root.context.getString(R.string.replenishment)
                } else {
                    moneyText =
                        root.context.getString(R.string.consumption_money, data.money.toString())
                    category = root.context.getString(R.string.spending)
                }
                money.text = moneyText
                categoryText.text = category
                time.text = data.time
            }
        }
    }
}

abstract class BaseHolder(view: View) : RecyclerView.ViewHolder(view) {

    abstract fun onBind(data: DetailWalletItem)

}
