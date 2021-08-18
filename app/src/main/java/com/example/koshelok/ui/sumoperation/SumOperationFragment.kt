package com.example.koshelok.ui.sumoperation

import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.koshelok.R
import com.example.koshelok.databinding.FragmentSumOperationTransactionBinding

class SumOperationFragment : Fragment(R.layout.fragment_sum_operation_transaction) {

    private val binding by viewBinding(FragmentSumOperationTransactionBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAddTextChangedListener()

        binding.addSumOperationButton.setOnClickListener {
            TODO()
        }
    }

    private fun setAddTextChangedListener() {
        binding.sumOperationEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                TODO()
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                TODO()
            }

            override fun afterTextChanged(str: Editable) {
                if (str.toString().trim().isNotEmpty() && str.toString().toInt() > 0) {
                    with(binding.addSumOperationButton) {
                        setBackgroundResource(R.drawable.button_enabled)
                        setTextColor(Color.WHITE)
                        true
                    }
                } else {
                    with(binding.addSumOperationButton) {
                        setBackgroundResource(R.drawable.button_not_available)
                        setTextColor(Color.GRAY)
                        false
                    }
                }
            }
        })
    }
}
