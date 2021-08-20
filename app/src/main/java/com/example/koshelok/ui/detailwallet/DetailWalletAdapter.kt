package com.example.koshelok.ui.detailwallet

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.koshelok.R

class DetailWalletAdapter(private val optionsCallback: OptionsCallback) :
    RecyclerView.Adapter<BaseHolder>() {

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

    private fun createHolder(parent: ViewGroup, type: Int): BaseHolder {
        return when (type) {
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
                        .inflate(R.layout.item_transaction, parent, false),
                    optionsCallback
                )
            }
            else -> throw IllegalStateException("error viewType")
        }
    }

    private companion object {
        const val HEADER_TYPE = 0
        const val DAY_TYPE = 1
        const val TRANSACTION_TYPE = 2
    }
}

interface OptionsCallback {
    fun deleteTransaction(data: DetailWalletItem.Transaction)
    fun editTransaction(data: DetailWalletItem.Transaction)
}

class DetailWalletCallback : DiffUtil.ItemCallback<DetailWalletItem>() {
    override fun areItemsTheSame(oldItem: DetailWalletItem, newItem: DetailWalletItem): Boolean {
        return if (oldItem is DetailWalletItem.Day && newItem is DetailWalletItem.Day) {
            oldItem.day == newItem.day
        } else if (oldItem is DetailWalletItem.HeaderDetailWallet && newItem is DetailWalletItem.HeaderDetailWallet) {
            oldItem.nameWallet == newItem.nameWallet
        } else if (oldItem is DetailWalletItem.Transaction && newItem is DetailWalletItem.Transaction) {
            oldItem.id == newItem.id
        } else oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: DetailWalletItem, newItem: DetailWalletItem): Boolean {
        return oldItem == newItem
    }
}
