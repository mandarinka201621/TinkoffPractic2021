package com.example.koshelok.ui.categories.categoryoperation

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.koshelok.R
import com.example.koshelok.databinding.FragmentCategoryOperationTransactionBinding
import com.example.koshelok.domain.Category
import com.example.koshelok.domain.Result
import com.example.koshelok.domain.TypeOperation
import com.example.koshelok.ui.main.appComponent
import com.example.koshelok.ui.transactions.sumoperation.SumOperationFragmentArgs
import com.example.koshelok.ui.util.ErrorHandler
import com.example.koshelok.ui.util.entity.CategoryEntity
import com.example.koshelok.ui.util.factory.ViewModelFactory
import javax.inject.Inject

class CategoryOperationFragment : Fragment(R.layout.fragment_category_operation_transaction),
    CategoryItemClickListener {

    @Inject
    lateinit var errorHandler: ErrorHandler

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val binding by viewBinding(FragmentCategoryOperationTransactionBinding::bind)
    private val viewModel: CategoryViewModel by viewModels { viewModelFactory }

    private val args by navArgs<SumOperationFragmentArgs>()
    private val transaction by lazy { args.transaction }

    private lateinit var adapterCategory: AdapterCategory

    override fun onAttach(context: Context) {
        super.onAttach(context)
        context.appComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.loadCategories(requireNotNull(transaction.type).code)
        setupRecycler()
        clickBackButton()
        binding.addSumOperationButton.setOnClickListener {
            launchAddTransactionFragment()
        }
        binding.createCategoryButton.setOnClickListener {
            launchCreateCategoryFragment()
        }
        transaction.let { viewModel.setSelectCategory(it) }
    }

    private fun setupRecycler() {
        adapterCategory = AdapterCategory(this@CategoryOperationFragment)
        binding.categoryRecyclerView.adapter = adapterCategory
        viewModel.listCategoryModel.observe(viewLifecycleOwner) { data: List<CategoryEntity>? ->
            if (data != null) {
                adapterCategory.submitList(data)
                isSelectedCategory()
            }
        }
        viewModel.resultData.observe(viewLifecycleOwner) { result: Result ->
            when (result) {
                is Result.Error -> errorHandler.createErrorShackBar(result.throwable, binding.root)
            }
        }
    }

    private fun isSelectedCategory() {
        if (viewModel.isSelect()) {
            binding.addSumOperationButton.isEnabled = true
        }
    }

    private fun launchAddTransactionFragment() {
        transaction.categoryEntity = viewModel.getEnableCategory()
        transaction.date = System.currentTimeMillis()
        findNavController().navigate(
            CategoryOperationFragmentDirections.actionCategoryOperationFragmentToAddOperationFragment(
                transaction
            )
        )
    }

    private fun launchCreateCategoryFragment() {
        findNavController().navigate(
            CategoryOperationFragmentDirections
                .actionCategoryOperationFragmentToCreateCategoryFragment(
                    Category(
                        id = 0,
                        type = TypeOperation.SELECT_INCOME,
                        operation = getString(R.string.category1),
                        iconId = 0,
                        color = 0
                    )
                )
        )
    }

    private fun clickBackButton() {
        binding.toolbar.setNavigationOnClickListener {
            requireActivity().onBackPressed()
        }
    }

    override fun onClickItem(position: Int, item: CategoryEntity) {
        viewModel.changeEnableState(position, item)
        adapterCategory.notifyDataSetChanged()
        isSelectedCategory()
    }
}
