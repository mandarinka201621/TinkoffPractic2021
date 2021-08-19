package com.example.koshelok.ui.typeoperation

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.koshelok.R
import com.example.koshelok.databinding.FragmentTypeOperationTransactionBinding

class TypeOperationFragment : Fragment(R.layout.fragment_type_operation_transaction) {

    private val binding by viewBinding(FragmentTypeOperationTransactionBinding::bind)
    private val viewModel: TypeOperationViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.typeOperation.observe(viewLifecycleOwner, Observer {
            checkChoose(it)
        })
        setClickListener()
    }

    private fun setClickListener() {
        binding.incomeLayout.setOnClickListener {
            viewModel.setSelectType(TypeOperationViewModel.Select.SELECT_INCOME)
        }
        binding.expenseLayout.setOnClickListener {
            viewModel.setSelectType(TypeOperationViewModel.Select.SELECT_EXPENSE)
        }
        binding.addTypeOperationButton.setOnClickListener {
            launchCategoryFinishedFragment()
        }
    }

    private fun launchCategoryFinishedFragment() {
        findNavController().navigate(R.id.action_typeOperationFragment_to_categoryOperationFragment)
    }

    private fun checkChoose(selected: TypeOperationViewModel.Select) {
        when (selected) {
            TypeOperationViewModel.Select.SELECT_INCOME -> {
                binding.incomeImageView.visibility = View.VISIBLE
                binding.expenseImageView.visibility = View.INVISIBLE
                setStateButton()
            }
            TypeOperationViewModel.Select.SELECT_EXPENSE -> {
                binding.incomeImageView.visibility = View.INVISIBLE
                binding.expenseImageView.visibility = View.VISIBLE
                setStateButton()
            }
        }
    }

    private fun setStateButton() {
        with(binding.addTypeOperationButton) {
            setBackgroundResource(R.drawable.button_enabled)
            setTextColor(Color.WHITE)
            isEnabled = true
        }
    }
}
