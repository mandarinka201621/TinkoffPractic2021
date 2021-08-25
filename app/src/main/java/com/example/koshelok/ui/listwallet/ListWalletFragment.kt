package com.example.koshelok.ui.listwallet

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.koshelok.R
import com.example.koshelok.databinding.FragmentListWalletBinding
import com.example.koshelok.domain.Currency
import com.example.koshelok.domain.Result
import com.example.koshelok.ui.MainScreenDataEntity
import com.example.koshelok.ui.appComponent
import com.example.koshelok.ui.factory.ViewModelFactory
import com.google.android.material.appbar.AppBarLayout
import javax.inject.Inject

class ListWalletFragment : Fragment(R.layout.fragment_list_wallet) {


    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val binding by viewBinding(FragmentListWalletBinding::bind)
    private val walletViewModel: ListWalletViewModel by viewModels { viewModelFactory }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        context.appComponent
            .inject(this)
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            val walletsAdapter = WalletListAdapter(::transitionToDetailWallet)
            walletList.run {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = walletsAdapter
            }

            binding.addWallet.setOnClickListener {
                launchTitleWalletFragment()
            }

            walletViewModel.resultData.observe(viewLifecycleOwner) { result: Result ->
                when (result) {
                    is Result.Success<*> -> {
                        result.data as MainScreenDataEntity
                        setupMainScreen(result.data, walletsAdapter)
                    }
                    is Result.Error -> {
                        //TODO сделать обработку ошибки
                    }
                }
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun setupMainScreen(
        data: MainScreenDataEntity,
        walletsAdapter: WalletListAdapter
    ) {
        with(binding) {
            with(exchangeRates) {
                firstCurrency.text = data.exchangeRatesEntity.firstCurrency.name
                firstCourse.text = data.exchangeRatesEntity.firstCourse
                firstCheck.isActivated = data.exchangeRatesEntity.firstIsUp
                secondCurrency.text =
                    data.exchangeRatesEntity.secondCurrency.name
                secondCourse.text = data.exchangeRatesEntity.secondCourse
                secondCheck.isActivated = data.exchangeRatesEntity.secondIsUp
                thirdCurrency.text = data.exchangeRatesEntity.thirdCurrency.name
                thirdCourse.text = data.exchangeRatesEntity.thirdCourse
                thirdCheck.isActivated = data.exchangeRatesEntity.thirdIsUp
            }
            walletsAdapter.setData(data.wallets)
            if (data.wallets.isEmpty()) {
                emptyWallets.visibility = View.VISIBLE
                disableScroll()
            } else {
                emptyWallets.visibility = View.GONE
                enableScroll()
            }
            with(balance) {
                amountMoney.text =
                    data.balanceEntity.amountMoney + Currency.RUB.icon
                incomeMoney.text =
                    data.balanceEntity.incomeMoney + Currency.RUB.icon
                consumptionMoney.text =
                    data.balanceEntity.consumptionMoney + Currency.RUB.icon
            }
        }
    }

    private fun enableScroll() {
        val params = binding.collapsedToolbar.layoutParams as AppBarLayout.LayoutParams
        params.scrollFlags = (
                AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL
                        or AppBarLayout.LayoutParams.SCROLL_FLAG_EXIT_UNTIL_COLLAPSED
                )
        binding.collapsedToolbar.layoutParams = params
    }

    private fun disableScroll() {
        val params = binding.collapsedToolbar.layoutParams as AppBarLayout.LayoutParams
        params.scrollFlags = AppBarLayout.LayoutParams.SCROLL_FLAG_NO_SCROLL
        binding.collapsedToolbar.layoutParams = params
    }

    private fun transitionToDetailWallet(walletId: Long) {
        findNavController().navigate(
            ListWalletFragmentDirections.actionWalletListFragmentToDetailWalletFragment(walletId)
        )
    }

    private fun launchTitleWalletFragment() {
        findNavController().navigate(R.id.action_walletListFragment_to_addTitleWalletFragment)
    }
}
