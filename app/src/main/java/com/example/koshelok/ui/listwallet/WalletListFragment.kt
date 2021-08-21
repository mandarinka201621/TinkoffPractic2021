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
import com.example.koshelok.ui.listwallet.entity.BalancEntity
import com.example.koshelok.ui.listwallet.entity.ExchangeRatesEntity
import com.example.koshelok.ui.listwallet.entity.WalletEntity

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

            viewModel.balanceData.observe(viewLifecycleOwner) { balanceModel: BalancEntity? ->
                if (balanceModel != null) {
                    with(balance) {
                        amountMoney.text = balanceModel.amountMoney
                        incomeMoney.text = balanceModel.incomeMoney
                        consumptionMoney.text = balanceModel.consumptionMoney
                    }
                }
            }

            viewModel.exchangeRatesData.observe(viewLifecycleOwner) { exchangeRatesEntity: ExchangeRatesEntity? ->
                if (exchangeRatesEntity != null) {
                    with(exchangeRates) {
                        firstCourse.text = exchangeRatesEntity.firstCourse
                        firstCheck.isActivated = exchangeRatesEntity.firstIsUp
                        secondCourse.text = exchangeRatesEntity.secondCourse
                        secondCheck.isActivated = exchangeRatesEntity.secondIsUp
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
}
