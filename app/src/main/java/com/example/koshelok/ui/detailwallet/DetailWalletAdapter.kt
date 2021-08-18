package com.example.koshelok.ui.detailwallet

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.koshelok.R

class DetailWalletAdapter : RecyclerView.Adapter<BaseHolder>() {

    private val diffUtil = AsyncListDiffer(this, DetailWalletCallback())

    fun setData(newData: List<DetailWalletItem>) {
        diffUtil.submitList(newData)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseHolder {
        return createHolder(parent, viewType)
    }

    override fun onBindViewHolder(holder: BaseHolder, position: Int) {
        holder.onBind(
            diffUtil.currentList[position]
        )
    }

    override fun getItemViewType(position: Int): Int {
        return when {
            diffUtil.currentList[position] is DetailWalletItem.HeaderDetailWallet -> {
                HEADER_TYPE
            }
            diffUtil.currentList[position]
                    is DetailWalletItem.Day -> {
                DAY_TYPE
            }
            diffUtil.currentList[position] is DetailWalletItem.Transaction -> {
                TRANSACTION_TYPE
            }
            else -> {
                super.getItemViewType(position)
            }
        }
    }

    override fun getItemCount(): Int = diffUtil.currentList.size

    private fun createHolder(parent: ViewGroup, viewType: Int): BaseHolder {
        return when (viewType) {
            HEADER_TYPE -> {
                HeaderHolder(
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.item_header_detail_wallet, parent, false)
                )
            }
            DAY_TYPE -> {
                DayHolder(
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.item_day, parent, false)
                )
            }
            TRANSACTION_TYPE -> {
                TransactionHolder(
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.item_transaction, parent, false)
                )
            }
            else -> {
                throw IllegalStateException("Unknown viewType")
            }
        }
    }

    private companion object {
        const val HEADER_TYPE = 0
        const val DAY_TYPE = 1
        const val TRANSACTION_TYPE = 2
    }
}

class DetailWalletCallback : DiffUtil.ItemCallback<DetailWalletItem>() {
    override fun areItemsTheSame(oldItem: DetailWalletItem, newItem: DetailWalletItem): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: DetailWalletItem, newItem: DetailWalletItem): Boolean {
        return oldItem == newItem
    }
}
