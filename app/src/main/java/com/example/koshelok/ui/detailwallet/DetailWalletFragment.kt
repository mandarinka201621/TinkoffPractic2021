package com.example.koshelok.ui.detailwallet

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.koshelok.R
import com.example.koshelok.databinding.FragmentDetailWalletBinding

class DetailWalletFragment : Fragment(R.layout.fragment_detail_wallet) {
    private val binding by viewBinding(FragmentDetailWalletBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            toolbar.inflateMenu(R.menu.menu_detail_wallet)
            addOperation.setOnClickListener {
                context?.let {
                    Toast.makeText(it, getString(R.string.click), Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.settingButton -> {
                //TODO сделать кнопку настроек
            }
        }
        return true
    }
}
