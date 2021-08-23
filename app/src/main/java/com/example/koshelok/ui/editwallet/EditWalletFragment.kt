package com.example.koshelok.ui.editwallet

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.koshelok.R
import com.example.koshelok.databinding.FragmentEditWalletBinding

class EditWalletFragment : Fragment(R.layout.fragment_edit_wallet) {

    private val binding by viewBinding(FragmentEditWalletBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setOnCLickEditWalletListener()
        with(binding) {
            /*    titleTextView.text = TODO()
                currencyTextView.text = TODO()
                limitTextView.text = TODO()*/
        }

        binding.createWalletButton.setOnClickListener {
            launchDetailWalletFragment()
        }
    }

    private fun launchDetailWalletFragment() {
        // TODO("сохранить кошелёк и перейти на экрна detailWallet")
    }

    private fun setOnCLickEditWalletListener() {
        with(binding) {
            titleLayout.setOnClickListener {

            }
            currencyLayout.setOnClickListener {

            }
            limitLayout.setOnClickListener {

            }
        }
    }
}
