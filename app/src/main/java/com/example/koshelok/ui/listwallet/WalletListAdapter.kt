package com.example.koshelok.ui.listwallet

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.koshelok.R
import com.example.koshelok.ui.listwallet.entity.WalletEntity

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

    override fun onViewRecycled(holder: WalletHolder) {
        super.onViewRecycled(holder)
        holder.resetSwipe()
    }

    fun setData(data: List<WalletEntity>) {
        diffUtil.submitList(data)
    }
}

class WalletCallback : DiffUtil.ItemCallback<WalletEntity>() {
    override fun areItemsTheSame(oldItem: WalletEntity, newItem: WalletEntity): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: WalletEntity, newItem: WalletEntity): Boolean {
        return oldItem == newItem
    }

}
