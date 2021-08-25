package com.example.koshelok.ui.transactions.typecategory

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.koshelok.R
import com.example.koshelok.databinding.FragmentAddTypeCategoryBinding
import com.example.koshelok.domain.TypeOperation
import com.example.koshelok.ui.main.appComponent
import com.example.koshelok.ui.util.factory.ViewModelFactory
import javax.inject.Inject

class CreateTypeCategoryFragment : Fragment(R.layout.fragment_add_type_category) {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val binding by viewBinding(FragmentAddTypeCategoryBinding::bind)
    private val viewModel: CreateTypeCategoryViewModel by viewModels { viewModelFactory }
    private val args by navArgs<CreateTypeCategoryFragmentArgs>()
    private val category by lazy { args.category }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        context.appComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setClickListener()
        setOnBackPressedListener()
        viewModel.typeCategory.observe(viewLifecycleOwner) {
            checkChoose(it)
        }
    }

    private fun setClickListener() {
        binding.typeLayout.incomeLayout.setOnClickListener {
            viewModel.setSelectType(TypeOperation.SELECT_INCOME)
        }
        binding.typeLayout.expenseLayout.setOnClickListener {
            viewModel.setSelectType(TypeOperation.SELECT_EXPENSE)
        }
        binding.typeLayout.addTypeOperationButton.setOnClickListener {
            launchCreateCategoryFragment()
        }
    }

    private fun launchCreateCategoryFragment() {
        category.type = viewModel.typeCategory.value ?: TypeOperation.SELECT_EXPENSE
        findNavController().popBackStack()
    }

    private fun checkChoose(selected: TypeOperation) {
        when (selected) {
            TypeOperation.SELECT_INCOME -> {
                binding.typeLayout.incomeImageView.visibility = View.VISIBLE
                binding.typeLayout.expenseImageView.visibility = View.INVISIBLE
                setStateButton()
            }
            TypeOperation.SELECT_EXPENSE -> {
                binding.typeLayout.incomeImageView.visibility = View.INVISIBLE
                binding.typeLayout.expenseImageView.visibility = View.VISIBLE
                setStateButton()
            }
        }
    }

    private fun setStateButton() {
        with(binding.typeLayout.addTypeOperationButton) {
            isEnabled = true
        }
    }

    private fun setOnBackPressedListener() {
        binding.typeLayout.toolbar.setNavigationOnClickListener {
            requireActivity().onBackPressed()
        }
    }
}
