package com.example.koshelok.ui.listwallet

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.koshelok.R

class WalletListAdapter : RecyclerView.Adapter<WalletsHolder>() {

    private val diffUtil = AsyncListDiffer(this, WalletCallback())

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WalletsHolder {
        return createHolder(viewType, LayoutInflater.from(parent.context), parent)
    }

    override fun onBindViewHolder(holder: WalletsHolder, position: Int) {
        holder.onBind(diffUtil.currentList[position])
    }

    override fun getItemCount() = diffUtil.currentList.size

    override fun getItemViewType(position: Int): Int {
        return when (diffUtil.currentList[position]) {
            is WalletsListItem.ExchangeRates -> EXCHANGE_RATES_TYPE
            is WalletsListItem.Wallet -> WALLET_TYPE
        }
    }

    override fun onViewRecycled(holder: WalletsHolder) {
        super.onViewRecycled(holder)
        if (holder is WalletHolder){
            holder.resetSwipe()
        }
    }

    fun setData(data: List<WalletsListItem>) {
        diffUtil.submitList(data)
    }

    private fun createHolder(
        viewType: Int,
        inflater: LayoutInflater,
        parent: ViewGroup
    ): WalletsHolder {
        return when (viewType) {
            EXCHANGE_RATES_TYPE -> {
                ExchangeRatesHolder(inflater.inflate(R.layout.item_exchange_rates, parent, false))
            }
            WALLET_TYPE -> {
                WalletHolder(inflater.inflate(R.layout.item_wallet, parent, false))
            }
            else -> throw IllegalStateException("error viewType")
        }
    }

    private companion object {
        const val EXCHANGE_RATES_TYPE = 0
        const val WALLET_TYPE = 1
    }
}

class WalletCallback : DiffUtil.ItemCallback<WalletsListItem>() {
    override fun areItemsTheSame(oldItem: WalletsListItem, newItem: WalletsListItem): Boolean {
        return if (oldItem is WalletsListItem.Wallet && newItem is WalletsListItem.Wallet)
            oldItem.id == newItem.id
        else if (oldItem is WalletsListItem.ExchangeRates && newItem is WalletsListItem.ExchangeRates)
            true
        else oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: WalletsListItem, newItem: WalletsListItem): Boolean {
        return oldItem == newItem
    }

}
