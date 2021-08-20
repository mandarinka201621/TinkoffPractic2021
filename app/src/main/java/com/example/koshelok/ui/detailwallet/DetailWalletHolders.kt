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

class HeaderHolder(view: View) : DetailWalletHolder(view) {

    private val binding by viewBinding(ItemHeaderDetailWalletBinding::bind)

    override fun onBind(data: DetailWalletItem) {
        if (data is DetailWalletItem.HeaderDetailWallet) {
            with(binding) {
                wallet.text = data.nameWallet
                amountMoney.text = data.amountMoney
                income.text = data.income
                consumption.text = data.consumption
                limit.text = data.limit
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

class TransactionHolder(view: View, private val swipeCallback: SwipeOptionsCallback) : DetailWalletHolder(view) {

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
                    moneyText = data.money
                    category = root.context.getString(R.string.replenishment)
                } else {
                    moneyText = data.money
                    category = root.context.getString(R.string.spending)
                }
                money.text = moneyText
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
}

abstract class DetailWalletHolder(view: View) : RecyclerView.ViewHolder(view) {

    abstract fun onBind(data: DetailWalletItem)

}
