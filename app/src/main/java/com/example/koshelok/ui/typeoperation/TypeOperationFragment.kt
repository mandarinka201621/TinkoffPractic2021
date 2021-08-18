package com.example.koshelok.ui.typeoperation

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.koshelok.R
import com.example.koshelok.databinding.FragmentTypeOperationTransactionBinding

class TypeOperationFragment : Fragment(R.layout.fragment_type_operation_transaction) {

    private val binding by viewBinding(FragmentTypeOperationTransactionBinding::bind)

    private var select: Int = NOTHING_SELECTED

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        select = savedInstanceState?.getInt(KEY_SELECT) ?: NOTHING_SELECTED
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        checkChoose(select)
        setClickListener()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY_SELECT, select)
    }

    private fun setClickListener() {
        binding.incomeLayout.setOnClickListener {
            checkChoose(SELECT_INCOME)
        }
        binding.expenseLayout.setOnClickListener {
            checkChoose(SELECT_EXPENSE)
        }
    }

    private fun checkChoose(selected: Int) {
        select = selected
        when (selected) {
            0 -> {
                binding.incomeImageView.visibility = View.VISIBLE
                binding.expenseImageView.visibility = View.INVISIBLE
                setStateButton()
            }
            1 -> {
                binding.incomeImageView.visibility = View.INVISIBLE
                binding.expenseImageView.visibility = View.VISIBLE
                setStateButton()
            }
            else -> {
            }
        }
    }

    private fun setStateButton() {
        with(binding.addTypeOperationButton) {
            setBackgroundResource(R.drawable.button_enabled)
            setTextColor(Color.WHITE)
        }
    }

    companion object {
        private const val SELECT_INCOME = 0
        private const val SELECT_EXPENSE = 1
        private const val NOTHING_SELECTED = -1

        private const val KEY_SELECT = "key_choose"
    }
}
