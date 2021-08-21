package com.example.koshelok.ui.addoperation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.koshelok.R
import com.example.koshelok.databinding.FragmentAddOperationTransactionBinding
import com.example.koshelok.extentions.getDayWithMonth
import com.example.koshelok.extentions.getNowDateTime
import com.example.koshelok.ui.sumoperation.SumOperationFragmentArgs
import com.example.koshelok.ui.typeoperation.TypeOperationViewModel

class AddOperationFragment : Fragment(R.layout.fragment_add_operation_transaction) {

    private val binding by viewBinding(FragmentAddOperationTransactionBinding::bind)

    private val args by navArgs<SumOperationFragmentArgs>()
    private val transaction by lazy { args.transaction }

    private val viewModel: AddOperationViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        transaction.let { viewModel.setTransaction(it) }
        setupTransaction()
        setOnBackPressedListener()
        binding.addOperationButton.setOnClickListener {
            findNavController().popBackStack(R.id.detailWalletFragment, false)
        }
    }

    private fun setupTransaction() {
        binding.sumTextView.text = transaction.sum
        binding.typeTextView.text = getTypeToString()
        binding.categoryTextView.text = transaction.categoryModel?.typeOperation
        binding.dateTextView.text =
            transaction.date?.getNowDateTime()?.getDayWithMonth(requireContext())
    }

    private fun getTypeToString() = when (viewModel.transaction.value?.type) {
        TypeOperationViewModel.Select.SELECT_EXPENSE -> requireContext().getString(R.string.income_text)
        TypeOperationViewModel.Select.SELECT_INCOME -> requireContext().getString(R.string.text_expense)
        else -> throw NullPointerException("Error type")
    }

    private fun setOnBackPressedListener() {
        binding.toolbar.setNavigationOnClickListener {
            requireActivity().onBackPressed()
        }
    }
}
