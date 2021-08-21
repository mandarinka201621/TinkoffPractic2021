package com.example.koshelok.ui.listwallet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.koshelok.R
import com.example.koshelok.databinding.FragmentWalletListBinding
import com.example.koshelok.ui.listwallet.model.BalanceModel
import com.example.koshelok.ui.listwallet.model.ExchangeRatesModel
import com.example.koshelok.ui.listwallet.model.WalletModel

class WalletListFragment : Fragment() {

    private val binding by viewBinding(FragmentWalletListBinding::bind)
    private val viewModel: WalletListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_wallet_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            val walletsAdapter = WalletListAdapter()
            walletList.run {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = walletsAdapter
            }

            viewModel.balanceData.observe(viewLifecycleOwner) { balanceModel: BalanceModel? ->
                if (balanceModel != null) {
                    with(balance) {
                        amountMoney.text = balanceModel.amountMoney
                        incomeMoney.text = balanceModel.incomeMoney
                        consumptionMoney.text = balanceModel.consumptionMoney
                    }
                }
            }

            viewModel.exchangeRatesData.observe(viewLifecycleOwner) { exchangeRatesModel: ExchangeRatesModel? ->
                if (exchangeRatesModel != null) {
                    with(exchangeRates) {
                        firstCourse.text = exchangeRatesModel.firstCourse
                        firstCheck.isActivated = exchangeRatesModel.firstIsUp
                        secondCourse.text = exchangeRatesModel.secondCourse
                        secondCheck.isActivated = exchangeRatesModel.secondIsUp
                        thirdCourse.text = exchangeRatesModel.thirdCourse
                        thirdCheck.isActivated = exchangeRatesModel.thirdIsUp
                    }
                }
            }

            viewModel.walletsData.observe(viewLifecycleOwner) { wallets: List<WalletModel>? ->
                if (wallets != null) {
                    walletsAdapter.setData(wallets)
                }
            }

        }
    }
}
