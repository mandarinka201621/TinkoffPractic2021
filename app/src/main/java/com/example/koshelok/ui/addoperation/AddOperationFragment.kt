package com.example.koshelok.ui.addoperation

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.koshelok.R
import com.example.koshelok.data.extentions.getCalendar
import com.example.koshelok.data.extentions.getDayWithMonth
import com.example.koshelok.databinding.FragmentAddOperationTransactionBinding
import com.example.koshelok.domain.Result
import com.example.koshelok.domain.TypeOperation
import com.example.koshelok.ui.appComponent
import com.example.koshelok.ui.factory.ViewModelFactory
import com.example.koshelok.ui.sumoperation.SumOperationFragmentArgs
import javax.inject.Inject

class AddOperationFragment : Fragment(R.layout.fragment_add_operation_transaction) {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val binding by viewBinding(FragmentAddOperationTransactionBinding::bind)
    private val args by navArgs<SumOperationFragmentArgs>()
    private val transaction by lazy { args.transaction }
    private val viewModel: AddOperationViewModel by viewModels { viewModelFactory }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        context.appComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        transaction.let { viewModel.setTransaction(it) }
        setupTransaction()
        setOnBackPressedListener()
        binding.addOperationButton.setOnClickListener {
            if (transaction.id != null) {
                viewModel.editTransaction(transaction)
            } else {
                viewModel.createTransaction(transaction)
            }
        }

        viewModel.responseServerData.observe(viewLifecycleOwner) { result: Result? ->
            when (result) {
                is Result.Success<*> -> findNavController().popBackStack(
                    R.id.detailWalletFragment,
                    false
                )
                is Result.Error -> {
                    //TODO вывести сообщение об ошибки на серваке
                }
            }
        }
    }

    private fun setupTransaction() {
        with(binding) {
            sumTextView.text = transaction.sum
            typeTextView.text = getTypeToString()
            categoryTextView.text = transaction.categoryEntity?.typeOperation
            dateTextView.text =
                transaction.date?.getCalendar()?.getDayWithMonth(root.context)
        }
    }

    private fun getTypeToString() = when (viewModel.transactionEntity.value?.type) {
        TypeOperation.SELECT_EXPENSE -> requireContext().getString(R.string.income_text)
        TypeOperation.SELECT_INCOME -> requireContext().getString(R.string.text_expense)
        else -> throw NullPointerException("Error type")
    }

    private fun setOnBackPressedListener() {
        binding.toolbar.setNavigationOnClickListener {
            requireActivity().onBackPressed()
        }
    }
}
