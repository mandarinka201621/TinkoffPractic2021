package com.example.koshelok.ui.editwallet

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.koshelok.R
import com.example.koshelok.databinding.FragmentEditWalletBinding

class EditWalletFragment : Fragment(R.layout.fragment_edit_wallet) {

    private val binding by viewBinding(FragmentEditWalletBinding::bind)

    private val args by navArgs<EditWalletFragmentArgs>()
    private val wallet by lazy { args.createWallet }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setOnCLickEditWalletListener()
        setOnBackPressedListener()
        with(binding) {
            titleTextView.text = wallet.name
            currencyTextView.text = getCurrency()
            limitTextView.text = wallet.limit
        }

        binding.createWalletButton.setOnClickListener {
            launchDetailWalletFragment()
        }
    }

    private fun getCurrency(): String =
        when (wallet.currency) {
            getString(R.string.russian_rub) -> getString(R.string.RUB)
            else -> {
                getString(R.string.limit_not_install)
            }
        }

    private fun launchDetailWalletFragment() {
        findNavController().navigate(R.id.action_editWalletFragment_to_detailWalletFragment)
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

    private fun setOnBackPressedListener() {
        binding.toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
    }
}
