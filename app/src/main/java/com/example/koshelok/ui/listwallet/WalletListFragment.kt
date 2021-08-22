package com.example.koshelok.ui.listwallet

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.koshelok.R
import com.example.koshelok.data.ViewModelFactory
import com.example.koshelok.databinding.FragmentWalletListBinding
import com.example.koshelok.ui.appComponent
import com.example.koshelok.ui.listwallet.entity.BalanceEntity
import com.example.koshelok.ui.listwallet.entity.ExchangeRatesEntity
import com.example.koshelok.ui.listwallet.entity.WalletEntity
import javax.inject.Inject

class WalletListFragment : Fragment(R.layout.fragment_wallet_list) {


    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val binding by viewBinding(FragmentWalletListBinding::bind)
    private val viewModel: WalletListViewModel by viewModels { viewModelFactory }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        context.appComponent
            .injectWalletsList(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            val walletsAdapter = WalletListAdapter()
            walletList.run {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = walletsAdapter
            }

            viewModel.balanceData.observe(viewLifecycleOwner) { balanceModel: BalanceEntity? ->
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
