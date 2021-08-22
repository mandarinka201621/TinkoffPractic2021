package com.example.koshelok.ui.sumoperation

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.koshelok.R
import com.example.koshelok.databinding.FragmentSumOperationTransactionBinding
import com.example.koshelok.extentions.hideKeyboard
import com.example.koshelok.extentions.showKeyboard

class SumOperationFragment : Fragment(R.layout.fragment_sum_operation_transaction) {

    private val binding by viewBinding(FragmentSumOperationTransactionBinding::bind)

    private val args by navArgs<SumOperationFragmentArgs>()
    private val transaction by lazy { args.transaction }
    private val viewModel: SumOperationViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAddTextChangedListener()
        setOnBackPressedListener()
        binding.sumOperationEditText.showKeyboard()
        binding.addSumOperationButton.setOnClickListener {
            launchTypeFragment()
        }
        transaction.let { viewModel.setSumType(it) }
    }

    private fun setOnBackPressedListener() {
        binding.toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun launchTypeFragment() {
        transaction.sum = binding.sumOperationEditText.text.toString()
        findNavController().navigate(
            SumOperationFragmentDirections
                .actionSumOperationFragmentToTypeOperationFragment(transaction)
        )
    }

    override fun onStop() {
        super.onStop()
        binding.sumOperationEditText.hideKeyboard()
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
}
