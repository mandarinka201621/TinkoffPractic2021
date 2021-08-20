package com.example.koshelok.ui.listwallet

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.koshelok.R

class WalletListAdapter : RecyclerView.Adapter<WalletHolder>() {

    private val diffUtil = AsyncListDiffer(this, WalletCallback())

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WalletHolder {
        return WalletHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_wallet, parent, false)
        )
    }

    override fun onBindViewHolder(holder: WalletHolder, position: Int) {
        holder.onBind(diffUtil.currentList[position])
    }

    override fun getItemCount() = diffUtil.currentList.size

    fun setData(data:List<Wallet>){
        diffUtil.submitList(data)
    }
}

class WalletCallback : DiffUtil.ItemCallback<Wallet>() {
    override fun areItemsTheSame(oldItem: Wallet, newItem: Wallet): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Wallet, newItem: Wallet): Boolean {
        return oldItem == newItem
    }

}
