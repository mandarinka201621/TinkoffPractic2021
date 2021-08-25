package com.example.koshelok.ui.limitwallet

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.koshelok.R
import com.example.koshelok.data.extentions.hideKeyboard
import com.example.koshelok.data.extentions.showKeyboard
import com.example.koshelok.databinding.FragmentLimitWalletBinding

class LimitWalletFragment : Fragment(R.layout.fragment_limit_wallet) {

    private val binding by viewBinding(FragmentLimitWalletBinding::bind)
    private val args by navArgs<LimitWalletFragmentArgs>()
    private val wallet by lazy { args.wallet }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAddTextChangedListener()
        setOnBackPressedListener()
        binding.limitWalletEditText.showKeyboard()
        binding.addLimitWalletButton.setOnClickListener {
            launchTypeFragment()
        }
    }

    private fun setOnBackPressedListener() {
        binding.toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun launchTypeFragment() {
        wallet.limit = binding.limitWalletEditText.text.toString().trimStart('0')
        findNavController().popBackStack()
    }

    override fun onStop() {
        super.onStop()
        binding.limitWalletEditText.hideKeyboard()
    }

    private fun setAddTextChangedListener() {
        binding.limitWalletEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) =
                Unit

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) =
                Unit

            override fun afterTextChanged(str: Editable) {
                if (str.toString().trim().isNotEmpty() && str.toString().toInt() > 0) {
                    with(binding.addLimitWalletButton) {
                        isEnabled = true
                    }
                } else {
                    with(binding.addLimitWalletButton) {
                        isEnabled = false
                    }
                }
            }
        })
    }
}
