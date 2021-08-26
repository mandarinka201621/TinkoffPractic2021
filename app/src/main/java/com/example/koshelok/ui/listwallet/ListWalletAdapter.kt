package com.example.koshelok.ui.listwallet

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.koshelok.R
import com.example.koshelok.databinding.ItemWalletBinding
import com.example.koshelok.ui.listwallet.entity.WalletEntity
import java.util.*

class WalletListAdapter(
    private val transitionToDetailWallet: (walletId: Long) -> Unit,
    private val deleteWallet: (walletId: Long) -> Unit
) :
    RecyclerView.Adapter<WalletListAdapter.WalletHolder>() {

    private val diffUtil = AsyncListDiffer(this, WalletCallback())

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WalletHolder {
        val viewHolder = WalletHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_wallet, parent, false)
        )

        viewHolder.itemView.setOnTouchListener(object : View.OnTouchListener {
            private var startClickTime: Long = 0

            override fun onTouch(v: View?, event: MotionEvent?): Boolean {
                when (event!!.action) {
                    MotionEvent.ACTION_DOWN -> {
                        startClickTime = Calendar.getInstance().timeInMillis
                    }
                    MotionEvent.ACTION_UP -> {
                        val clickDuration: Long =
                            Calendar.getInstance().timeInMillis - startClickTime
                        if (clickDuration < MAX_CLICK_DURATION
                            && viewHolder.adapterPosition != RecyclerView.NO_POSITION
                        ) {
                            transitionToDetailWallet(diffUtil.currentList[viewHolder.adapterPosition].id)
                        }
                    }
                }
                return false
            }
        })
        return viewHolder
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

    fun isEmptyList() = diffUtil.currentList.isEmpty()

    private companion object {
        const val MAX_CLICK_DURATION = 50
    }

    inner class WalletHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding by viewBinding(ItemWalletBinding::bind)

        @SuppressLint("SetTextI18n")
        fun onBind(data: WalletEntity) {
            with(binding) {
                amountMoney.text = data.amountMoney + " " + data.currency.icon
                nameWallet.text = data.name
                deleteButton.setOnClickListener {
                    deleteWallet(data.id)
                }
            }
        }

        fun resetSwipe() {
            binding.swipeLayout.reset()
        }
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
