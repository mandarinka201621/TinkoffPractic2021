package com.example.koshelok.ui.categoryoperation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.koshelok.R
import com.example.koshelok.databinding.FragmentCategoryOperationTransactionBinding
import com.example.koshelok.ui.sumoperation.SumOperationFragmentArgs

class CategoryOperationFragment : Fragment(R.layout.fragment_category_operation_transaction) {

    private val binding by viewBinding(FragmentCategoryOperationTransactionBinding::bind)
    private val viewModel: CategoryViewModel by viewModels()

    private val args by navArgs<SumOperationFragmentArgs>()
    private val transaction by lazy { args.transaction }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecycler()
        clickBackButton()
        isSelectedCategory()
        binding.addSumOperationButton.setOnClickListener {
            launchAddTransactionFragment()
        }
        transaction.let { viewModel.setSelectCategory(it) }
    }

    private fun setupRecycler() {
        val adapterCategory = AdapterCategory()
        binding.categoryRecyclerView.adapter = adapterCategory
        viewModel.listCategoryModel.observe(viewLifecycleOwner, Observer {
            adapterCategory.submitList(it)
        })

        adapterCategory.onCategoryItemClick = {
            viewModel.changeEnableState(it)
            isSelectedCategory()
        }
    }

    private fun isSelectedCategory() {
        if (viewModel.isSelect() == true) {
            binding.addSumOperationButton.isEnabled = true
        }
    }

    private fun launchAddTransactionFragment() {
        transaction.categoryModel = viewModel.getEnableCategory()
        transaction.date = viewModel.getDate()
        findNavController().navigate(
            CategoryOperationFragmentDirections.actionCategoryOperationFragmentToAddOperationFragment(
                transaction
            )
        )
    }

    private fun clickBackButton() {
        binding.toolbar.setNavigationOnClickListener {
            requireActivity().onBackPressed()
        }
    }
}
