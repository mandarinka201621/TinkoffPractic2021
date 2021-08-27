package com.example.koshelok.ui.wallet.editwallet

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
import com.example.koshelok.ui.main.appComponent
import com.example.koshelok.ui.util.factory.ViewModelFactory
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
            val limit =
                if (wallet.limit == null) getString(R.string.limit_not_install) else wallet.limit
            limitTextView.text = limit
            createWalletButton.setOnClickListener {
                activeButton()
                viewModel.createWallet(wallet)
            }

            viewModel.walletIdData.observe(viewLifecycleOwner) { walletId ->

                launchDetailWalletFragment(walletId)
            }

            viewModel.errorData.observe(viewLifecycleOwner) { throwable ->
                createWalletButton.isClickable = true
                finishButton()
            }
        }
    }

    private fun getCurrency(): String =
        when (wallet.currency) {
            Currency.EUR -> {
                "${binding.root.context.getString(R.string.eur)} (${Currency.EUR.name})"
            }
            Currency.RUB -> {
                "${binding.root.context.getString(R.string.rub)} (${Currency.RUB.name})"
            }
            Currency.USD -> {
                "${binding.root.context.getString(R.string.usd)} (${Currency.USD.name})"
            }
            Currency.CHF -> {
                "${binding.root.context.getString(R.string.chf)} (${Currency.CHF.name})"
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
                findNavController().popBackStack()
            }
            currencyLayout.setOnClickListener {
                findNavController().navigate(
                    EditWalletFragmentDirections.actionEditWalletFragmentToCurrencyWalletFragment(
                        wallet
                    )
                )
            }
            limitLayout.setOnClickListener {
                findNavController().navigate(
                    EditWalletFragmentDirections.actionEditWalletFragmentToLimitWalletFragment(
                        wallet
                    )
                )
            }
        }
    }

    private fun activeButton() {
        with(binding) {
            progressIndicator.visibility = View.VISIBLE
            buttonText.visibility = View.INVISIBLE
            createWalletButton.isClickable = false
        }
    }

    private fun finishButton() {
        with(binding) {
            progressIndicator.visibility = View.GONE
            buttonText.visibility = View.VISIBLE
        }
    }

    private fun setOnBackPressedListener() {

        binding.toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
    }
}
