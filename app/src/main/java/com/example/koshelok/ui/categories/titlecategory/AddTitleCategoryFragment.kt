package com.example.koshelok.ui.categories.titlecategory

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.koshelok.R
import com.example.koshelok.databinding.FragmentAddTitleCategoryBinding
import com.example.koshelok.ui.transactions.typecategory.CreateTypeCategoryFragmentArgs
import com.example.koshelok.ui.util.extentions.hideKeyboard
import com.example.koshelok.ui.util.extentions.showKeyboard

class AddTitleCategoryFragment: Fragment(R.layout.fragment_add_title_category) {

    private val binding by viewBinding(FragmentAddTitleCategoryBinding::bind)
    private val args by navArgs<CreateTypeCategoryFragmentArgs>()
    private val category by lazy { args.category }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAddTextChangedListener()
        setOnBackPressedListener()
        binding.titleCategoryEditText.showKeyboard()
        binding.fartherButton.setOnClickListener {
            launchEditWalletFragment()
        }
    }

    override fun onStop() {
        super.onStop()
        binding.titleCategoryEditText.hideKeyboard()
    }

    private fun setOnBackPressedListener() {
        binding.toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun launchEditWalletFragment() {
        category.operation = binding.titleCategoryEditText.text.toString().trim()
        findNavController().popBackStack()
    }

    private fun setAddTextChangedListener() {
        binding.titleCategoryEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) =
                Unit

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) =
                Unit

            override fun afterTextChanged(str: Editable) {
                if (str.toString().trim() > "") {
                    with(binding.fartherButton) {
                        isEnabled = true
                    }
                } else {
                    with(binding.fartherButton) {
                        isEnabled = false
                    }
                }
            }
        })
    }
}
