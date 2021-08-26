package com.example.koshelok.ui.detailwallet

import android.annotation.SuppressLint
import android.content.res.ColorStateList
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.koshelok.R
import com.example.koshelok.databinding.ItemDayBinding
import com.example.koshelok.databinding.ItemHeaderDetailWalletBinding
import com.example.koshelok.databinding.ItemTransactionBinding
import com.example.koshelok.domain.TypeOperation

class HeaderHolder(view: View) : DetailWalletHolder(view) {

    private val binding by viewBinding(ItemHeaderDetailWalletBinding::bind)

    @SuppressLint("SetTextI18n")
    override fun onBind(data: DetailWalletItem) {
        if (data is DetailWalletItem.HeaderDetailWallet) {
            with(binding) {
                wallet.text = data.nameWallet
                amountMoney.text = data.amountMoney + " " + data.currency.icon
                income.text = data.income + " " + data.currency.icon
                consumption.text = data.consumption + " " + data.currency.icon
                if (data.limit == null) {
                    limit.visibility = View.GONE
                } else {
                    limit.text = "/${data.limit}"
                }
                exceededLimit.visibility = if (data.isExceededLimit) {
                    limit.setTextColor(root.context.getColor(R.color.red))
                    View.VISIBLE
                } else {
                    View.GONE
                }
            }
        }
    }
}

class DayHolder(view: View) : DetailWalletHolder(view) {

    private val binding by viewBinding(ItemDayBinding::bind)

    override fun onBind(data: DetailWalletItem) {
        if (data is DetailWalletItem.Day) {
            binding.day.text = data.day
        }
    }
}

class TransactionHolder(view: View, private val swipeCallback: SwipeOptionsCallback) :
    DetailWalletHolder(view) {

    private val binding by viewBinding(ItemTransactionBinding::bind)

    @SuppressLint("SetTextI18n")
    override fun onBind(data: DetailWalletItem) {
        if (data is DetailWalletItem.Transaction) {
            with(binding) {
                icon.setImageDrawable(ContextCompat.getDrawable(root.context, data.category.iconId))
                icon.backgroundTintList = ColorStateList.valueOf(data.category.color)
                typeOperation.text = data.category.operation
                val moneyText: String
                val category: String
                when (data.category.type) {
                    TypeOperation.SELECT_INCOME -> {
                        moneyText = data.money
                        category = root.context.getString(R.string.replenishment)
                    }
                    TypeOperation.SELECT_EXPENSE -> {
                        moneyText = "-${data.money}"
                        category = root.context.getString(R.string.spending)
                    }
                }
                money.text = moneyText + " " + data.currency.icon
                categoryText.text = category
                time.text = data.time
                deleteButton.setOnClickListener {
                    swipeCallback.deleteTransaction(data)
                }
                editButton.setOnClickListener {

                }
            }
        }
    }

    fun resetSwipe() {
        binding.swipeLayout.reset()
    }
}

abstract class DetailWalletHolder(view: View) : RecyclerView.ViewHolder(view) {

    abstract fun onBind(data: DetailWalletItem)

}
