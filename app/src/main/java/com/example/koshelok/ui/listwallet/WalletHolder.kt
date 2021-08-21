package com.example.koshelok.ui.listwallet

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.koshelok.databinding.ItemWalletBinding
import com.example.koshelok.ui.listwallet.model.WalletModel


class WalletHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding by viewBinding(ItemWalletBinding::bind)

    fun onBind(data: WalletModel) {
        with(binding) {
            amountMoney.text = data.amountMoney
            nameWallet.text = data.name
        }
    }

    fun resetSwipe() {
        binding.swipeLayout.reset()
    }
}
