package com.example.koshelok.ui.wallet.currencywallet

import androidx.recyclerview.widget.DiffUtil
import com.example.koshelok.ui.util.entity.CurrencyEntity

class CurrencyDiffCallback : DiffUtil.ItemCallback<CurrencyEntity>() {

    override fun areItemsTheSame(oldItem: CurrencyEntity, newItem: CurrencyEntity): Boolean {
        return oldItem === newItem
    }

    override fun areContentsTheSame(oldItem: CurrencyEntity, newItem: CurrencyEntity): Boolean {
        return oldItem == newItem
    }
}
