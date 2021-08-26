package com.example.koshelok.ui.categories.createcategory

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.koshelok.R
import com.example.koshelok.databinding.FragmentCreateCategoryBinding
import com.example.koshelok.domain.LoadState
import com.example.koshelok.domain.TypeOperation
import com.example.koshelok.ui.main.appComponent
import com.example.koshelok.ui.transactions.typecategory.CreateTypeCategoryFragmentArgs
import com.example.koshelok.ui.util.ErrorHandler
import com.example.koshelok.ui.util.entity.IconEntity
import com.example.koshelok.ui.util.factory.ViewModelFactory
import petrov.kristiyan.colorpicker.ColorPicker
import petrov.kristiyan.colorpicker.ColorPicker.OnChooseColorListener
import javax.inject.Inject

class CreateCategoryFragment : Fragment(R.layout.fragment_create_category) {

    private val binding by viewBinding(FragmentCreateCategoryBinding::bind)

    @Inject
    lateinit var errorHandler: ErrorHandler

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val args by navArgs<CreateTypeCategoryFragmentArgs>()
    private val category by lazy { args.category }
    private val viewModel: CreateCategoryViewModel by viewModels { viewModelFactory }

    private lateinit var adapterIcon: AdapterIcon

    override fun onAttach(context: Context) {
        super.onAttach(context)
        context.appComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecycler()

        viewModel.enableColor.observe(viewLifecycleOwner, Observer {
            adapterIcon.setEnableColor(it)
            binding.adkColorTextView.setTextColor(it)
            adapterIcon.notifyDataSetChanged()
        })

        with(binding) {
            typeTextView.text = getTypeToString()
            titleTextView.text = category.operation

            typeTextView.setOnClickListener {
                launchCreateTypeCategoryFragment()
            }
            titleTextView.setOnClickListener {
                launchCreateTitleCategoryFragment()
            }
            adkColorTextView.setOnClickListener {
                setColorPickerClickListener()
            }
            createCategoryButton.setOnClickListener {
                category.color = viewModel.enableColor.value ?: 0
                category.iconId = viewModel.getEnableIcon()?.resIcon ?: 0
                viewModel.createCategory(category)
            }
            binding.toolbar.setNavigationOnClickListener {
                requireActivity().onBackPressed()
            }
            viewModel.errorData.observe(viewLifecycleOwner) { throwable ->
                errorHandler.createErrorToastBar(throwable, layoutInflater, requireContext())
            }

            viewModel.loadStateData.observe(viewLifecycleOwner) { state: LoadState ->
                when (state) {
                    LoadState.SUCCESS -> findNavController().popBackStack()
                }
            }
        }
    }

    private fun getTypeToString() = when (category.type) {
        TypeOperation.SELECT_EXPENSE -> requireContext().getString(R.string.text_expense)
        TypeOperation.SELECT_INCOME -> requireContext().getString(R.string.income_text)
    }

    private fun setColorPickerClickListener() {
        val colorPicker = ColorPicker(requireActivity())
        with(colorPicker) {
            setTitle(getString(R.string.choose_color))
            setRoundColorButton(true)
            setOnChooseColorListener(
                object : OnChooseColorListener {
                    override fun onChooseColor(position: Int, color: Int) {
                        if (color != 0) {
                            viewModel.setEnableColor(color)
                        }
                    }
                    override fun onCancel() = Unit
                })
            show()
        }
    }

    private fun launchCreateTypeCategoryFragment() {
        category.type = category.type
        findNavController().navigate(
            CreateCategoryFragmentDirections.actionCreateCategoryFragmentToAddTypeCategoryFragment(
                category
            )
        )
    }

    private fun launchCreateTitleCategoryFragment() {
        category.type = category.type
        findNavController().navigate(
            CreateCategoryFragmentDirections.actionCreateCategoryFragmentToAddTitleCategoryFragment(
                category
            )
        )
    }

    private fun setupRecycler() {
        adapterIcon = AdapterIcon(::onClickItem)
        binding.categoryRecyclerView.adapter = adapterIcon
        viewModel.listIconModel.observe(viewLifecycleOwner) { data: List<IconEntity>? ->
            if (data != null) {
                adapterIcon.submitList(data)
            }
        }
    }

    private fun isSelectedCategory() {
        if (viewModel.isSelect()) {
            binding.createCategoryButton.isEnabled = true
        }
    }

    private fun onClickItem(position: Int, item: IconEntity) {
        viewModel.changeEnableState(position, item)
        adapterIcon.notifyDataSetChanged()
        isSelectedCategory()
    }
}
