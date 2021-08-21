package com.example.koshelok.ui.listwallet

import android.graphics.drawable.Drawable
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.koshelok.R
import com.example.koshelok.databinding.ItemExchangeRatesBinding
import com.example.koshelok.databinding.ItemWalletBinding


class WalletHolder(view:View) : WalletsHolder(view) {
    private val binding by viewBinding(ItemWalletBinding::bind)

    override fun onBind(data: WalletsListItem) {
        if (data is WalletsListItem.Wallet) {
            with(binding) {
                amountMoney.text = data.amountMoney
                nameWallet.text = data.name
            }
        }
    }

    fun resetSwipe(){
        binding.swipeLayout.reset()
    }
}

class ExchangeRatesHolder(view:View) : WalletsHolder(view){
    private val binding by viewBinding(ItemExchangeRatesBinding::bind)

    override fun onBind(data: WalletsListItem) {
        if (data is WalletsListItem.ExchangeRates) {
            with(binding) {
                firstCourse.text = data.firstCourse
                firstCheck.background = getDrawable(data.firstIsUp)
                secondCourse.text = data.secondCourse
                secondCheck.background = getDrawable(data.secondIsUp)
                thirdCourse.text = data.thirdCourse
                thirdCheck.background = getDrawable(data.thirdIsUp)
            }
        }
    }

    private fun getDrawable(isUp:Boolean):Drawable?{
        return if (isUp){
            ContextCompat.getDrawable(binding.root.context,R.drawable.check_up)
        }
        else {
            ContextCompat.getDrawable(binding.root.context,R.drawable.check_down)
        }
    }

}

abstract class WalletsHolder(view: View) : RecyclerView.ViewHolder(view) {

    abstract fun onBind(data: WalletsListItem)
}
