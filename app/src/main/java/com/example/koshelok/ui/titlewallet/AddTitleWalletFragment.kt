package com.example.koshelok.ui.titlewallet

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.koshelok.R
import com.example.koshelok.databinding.FragmentAddTitleWalletBinding
import com.example.koshelok.extentions.hideKeyboard
import com.example.koshelok.extentions.showKeyboard

class AddTitleWalletFragment : Fragment(R.layout.fragment_add_title_wallet) {

    private val binding by viewBinding(FragmentAddTitleWalletBinding::bind)

    //private val viewModel: SumOperationViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAddTextChangedListener()
        setOnBackPressedListener()
        binding.titleWalletEditText.showKeyboard()
        binding.fartherButton.setOnClickListener {
            launchEditWalletFragment()
        }
       TODO("Сохранение wallet в viewModel")
    }

    override fun onStop() {
        super.onStop()
        binding.titleWalletEditText.hideKeyboard()
    }

    private fun setOnBackPressedListener() {
        binding.toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun launchEditWalletFragment() {
        binding.titleWalletEditText.hideKeyboard()
            TODO("Сделать переход и засесить изменения wallet")
    }

    private fun setAddTextChangedListener() {
        binding.titleWalletEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) =
                Unit

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) =
                Unit

            override fun afterTextChanged(str: Editable) {
                if (str.toString().trim().isNotEmpty() && str.toString().toInt() > 0) {
                    with(binding.fartherButton) {
                        isEnabled = true
                    }
                } else {
                    with(binding.fartherButton) {
                        isEnabled = false
                    }
                }
            }
        })
    }
}
