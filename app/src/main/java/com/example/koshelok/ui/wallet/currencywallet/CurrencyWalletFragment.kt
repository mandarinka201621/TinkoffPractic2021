package com.example.koshelok.ui.wallet.currencywallet

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.koshelok.R
import com.example.koshelok.databinding.FragmentCurrencyWalletBinding
import com.example.koshelok.domain.Currency
import com.example.koshelok.ui.main.appComponent
import com.example.koshelok.ui.util.entity.CurrencyEntity
import com.example.koshelok.ui.util.factory.ViewModelFactory
import javax.inject.Inject

class CurrencyWalletFragment : Fragment(R.layout.fragment_currency_wallet){

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val binding by viewBinding(FragmentCurrencyWalletBinding::bind)
    private val viewModel: CurrencyWalletFragmentViewModel by viewModels{viewModelFactory}
    private val args by navArgs<CurrencyWalletFragmentArgs>()
    private val wallet by lazy { args.wallet }

    private lateinit var adapterCurrency: AdapterCurrency

    override fun onAttach(context: Context) {
        super.onAttach(context)
        context.appComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecycler()
        clickBackButton()
        binding.addCurrencyWalletButton .setOnClickListener {
            launchEditWalletFragment()
        }
    }

    private fun setupRecycler() {
        adapterCurrency = AdapterCurrency(::onClickItem)
        binding.currencyRecycler.adapter = adapterCurrency
        viewModel.listCurrencyModel.observe(viewLifecycleOwner) { data: List<CurrencyEntity>? ->
            if (data != null) {
                adapterCurrency.submitList(data)
            }
        }
    }

    private fun launchEditWalletFragment() {
        wallet.currency = viewModel.getEnableCurrency()?.currency ?: Currency.RUB
        findNavController().popBackStack()
    }

    private fun clickBackButton() {
        binding.toolbar.setNavigationOnClickListener {
            requireActivity().onBackPressed()
        }
    }

     private fun onClickItem(position: Int, item: CurrencyEntity) {
        viewModel.changeEnableState(position, item)
        adapterCurrency.notifyDataSetChanged()
    }
}
