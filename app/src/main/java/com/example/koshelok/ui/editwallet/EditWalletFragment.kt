package com.example.koshelok.ui.editwallet

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.koshelok.R
import com.example.koshelok.databinding.FragmentEditWalletBinding
import com.example.koshelok.domain.Currency
import com.example.koshelok.domain.Result
import com.example.koshelok.ui.appComponent
import com.example.koshelok.ui.factory.ViewModelFactory
import javax.inject.Inject

class EditWalletFragment : Fragment(R.layout.fragment_edit_wallet) {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val binding by viewBinding(FragmentEditWalletBinding::bind)
    private val args by navArgs<EditWalletFragmentArgs>()
    private val wallet by lazy { args.createWallet }
    private val viewModel: EditWalletViewModel by viewModels { viewModelFactory }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        context.appComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setOnCLickEditWalletListener()
        setOnBackPressedListener()
        with(binding) {
            titleTextView.text = wallet.name
            currencyTextView.text = getCurrency()
            limitTextView.text = wallet.limit
            createWalletButton.setOnClickListener {
                viewModel.createWallet(wallet)
            }

            viewModel.responseServerData.observe(viewLifecycleOwner) { result: Result? ->
                when (result) {
                    is Result.Success<*> -> launchDetailWalletFragment(result.data as Long)
                    is Result.Error -> {
                        //TODO показать ошибку
                    }
                }

            }
        }
    }

    private fun getCurrency(): String =
        when (wallet.currency) {
            Currency.RUB -> getString(R.string.RUB)
            else -> {
                getString(R.string.limit_not_install)
            }
        }

    private fun launchDetailWalletFragment(walletId: Long) {
        findNavController().navigate(
            EditWalletFragmentDirections.actionEditWalletFragmentToDetailWalletFragment(walletId)
        )
    }

    private fun setOnCLickEditWalletListener() {
        with(binding) {
            titleLayout.setOnClickListener {

            }
            currencyLayout.setOnClickListener {

            }
            limitLayout.setOnClickListener {

            }
        }
    }

    private fun setOnBackPressedListener() {
        binding.toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
    }
}
