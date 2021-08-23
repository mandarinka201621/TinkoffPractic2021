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
import com.example.koshelok.ui.appComponent
import com.example.koshelok.ui.factory.ViewModelFactory
import com.example.koshelok.ui.listwallet.entity.BalanceEntity
import com.example.koshelok.ui.listwallet.entity.ExchangeRatesEntity
import com.example.koshelok.ui.listwallet.entity.WalletEntity
import javax.inject.Inject

class ListWalletFragment : Fragment(R.layout.fragment_list_wallet) {


    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val binding by viewBinding(FragmentListWalletBinding::bind)
    private val viewModel: WalletListViewModel by viewModels { viewModelFactory }

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

            viewModel.balanceData.observe(viewLifecycleOwner) { balanceModel: BalanceEntity? ->
                if (balanceModel != null) {
                    with(balance) {
                        amountMoney.text = balanceModel.amountMoney + Currency.RUB.icon
                        incomeMoney.text = balanceModel.incomeMoney + Currency.RUB.icon
                        consumptionMoney.text = balanceModel.consumptionMoney + Currency.RUB.icon
                    }
                }
            }

            viewModel.exchangeRatesData.observe(viewLifecycleOwner) { exchangeRatesEntity: ExchangeRatesEntity? ->
                if (exchangeRatesEntity != null) {
                    with(exchangeRates) {
                        firstCurrency.text = exchangeRatesEntity.firstCurrency.name
                        firstCourse.text = exchangeRatesEntity.firstCourse
                        firstCheck.isActivated = exchangeRatesEntity.firstIsUp
                        secondCurrency.text = exchangeRatesEntity.secondCurrency.name
                        secondCourse.text = exchangeRatesEntity.secondCourse
                        secondCheck.isActivated = exchangeRatesEntity.secondIsUp
                        thirdCurrency.text = exchangeRatesEntity.thirdCurrency.name
                        thirdCourse.text = exchangeRatesEntity.thirdCourse
                        thirdCheck.isActivated = exchangeRatesEntity.thirdIsUp
                    }
                }
            }

            viewModel.walletsData.observe(viewLifecycleOwner) { wallets: List<WalletEntity>? ->
                if (wallets != null) {
                    walletsAdapter.setData(wallets)
                    emptyWallets.visibility = if (wallets.isEmpty()) View.VISIBLE else View.GONE
                }
            }

        }
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
