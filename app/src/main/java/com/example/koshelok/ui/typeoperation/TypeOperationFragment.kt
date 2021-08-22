package com.example.koshelok.ui.typeoperation

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.koshelok.R
import com.example.koshelok.data.ViewModelFactory
import com.example.koshelok.databinding.FragmentTypeOperationTransactionBinding
import com.example.koshelok.ui.appComponent
import com.example.koshelok.ui.sumoperation.SumOperationFragmentArgs
import javax.inject.Inject

class TypeOperationFragment : Fragment(R.layout.fragment_type_operation_transaction) {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val binding by viewBinding(FragmentTypeOperationTransactionBinding::bind)
    private val viewModel:TypeOperationViewModel by viewModels { viewModelFactory }
    private val args by navArgs<SumOperationFragmentArgs>()
    private val transaction by lazy { args.transaction }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        context.appComponent
            .injectTypeOperationFragment(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.typeOperation.observe(viewLifecycleOwner) {
            Log.d("tut_operation", it.toString())
            checkChoose(it)
        }
        setClickListener()
        setOnBackPressedListener()
        transaction.let { viewModel.setSelectType(it) }
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
        transaction.type = viewModel.typeOperation.value
        findNavController().navigate(
            TypeOperationFragmentDirections
                .actionTypeOperationFragmentToCategoryOperationFragment(transaction)
        )
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

    private fun setOnBackPressedListener() {
        binding.toolbar.setNavigationOnClickListener {
            requireActivity().onBackPressed()
        }
    }
}
