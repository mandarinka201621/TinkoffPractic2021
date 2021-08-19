package com.example.koshelok.ui.sumoperation

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.koshelok.R
import com.example.koshelok.databinding.FragmentSumOperationTransactionBinding

class SumOperationFragment : Fragment(R.layout.fragment_sum_operation_transaction) {

    private val binding by viewBinding(FragmentSumOperationTransactionBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAddTextChangedListener()
        backPressedListener()
        binding.sumOperationEditText.showKeyboard()
        binding.addSumOperationButton.setOnClickListener {
            launchTypeFragment()
        }
    }

    private fun backPressedListener() {
        binding.toolbar.setNavigationOnClickListener {
            findNavController().popBackStack(R.id.detailWalletFragment, false)
        }
    }

    private fun launchTypeFragment() {
        binding.sumOperationEditText.hideKeyboard()
        TODO()
    }

    private fun setAddTextChangedListener() {
        binding.sumOperationEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) =
                Unit

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) =
                Unit

            override fun afterTextChanged(str: Editable) {
                if (str.toString().trim().isNotEmpty() && str.toString().toInt() > 0) {
                    with(binding.addSumOperationButton) {
                        isEnabled = true
                    }
                } else {
                    with(binding.addSumOperationButton) {
                        isEnabled = false
                    }
                }
            }
        })
    }

    private fun View.showKeyboard() {
        this.requestFocus()
        val inputMethodManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.showSoftInput(this, InputMethodManager.SHOW_IMPLICIT)
    }

    private fun View.hideKeyboard() {
        val inputMethodManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(windowToken, 0)
    }
}
