package com.example.koshelok.ui.wallet.currencywallet

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.koshelok.R
import com.example.koshelok.databinding.ItemCurrencyBinding
import com.example.koshelok.domain.Currency
import com.example.koshelok.ui.util.entity.CurrencyEntity

class AdapterCurrency(private val onCurrencyItemClick: (position: Int, item: CurrencyEntity) -> Unit) :
    ListAdapter<CurrencyEntity, AdapterCurrency.CurrencyViewHolder>(CurrencyDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): CurrencyViewHolder {
        val rootView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_currency, parent, false)
        val viewHolder = CurrencyViewHolder(rootView)
        viewHolder.itemView.setOnClickListener {
            if (viewHolder.adapterPosition != RecyclerView.NO_POSITION)
                onClicked(viewHolder.adapterPosition, currentList[viewHolder.adapterPosition])
        }
        return viewHolder
    }

    override fun getItemCount() = currentList.size

    override fun onBindViewHolder(holder: CurrencyViewHolder, position: Int) {
        holder.onBind(currentList[position])
    }

    private fun onClicked(position: Int, item: CurrencyEntity) {
        onCurrencyItemClick(position, item)
    }

    inner class CurrencyViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        private val binding by viewBinding(ItemCurrencyBinding::bind)

        fun onBind(data: CurrencyEntity) {
            with(binding) {
                currencyTextView.text = when (data.currency) {
                    Currency.EUR -> {
                        "${binding.root.context.getString(R.string.eur)} (${Currency.EUR.name})"
                    }
                    Currency.RUB -> {
                        "${binding.root.context.getString(R.string.rub)} (${Currency.RUB.name})"
                    }
                    Currency.USD -> {
                        "${binding.root.context.getString(R.string.usd)} (${Currency.USD.name})"
                    }
                    Currency.CHF -> {
                        "${binding.root.context.getString(R.string.chf)} (${Currency.CHF.name})"
                    }
                }
                binding.currencySwitch.isChecked = data.isEnable
            }
        }
    }
}
