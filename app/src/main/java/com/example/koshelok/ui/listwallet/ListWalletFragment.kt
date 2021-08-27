package com.example.koshelok.ui.listwallet

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.koshelok.R
import com.example.koshelok.databinding.FragmentListWalletBinding
import com.example.koshelok.domain.Currency
import com.example.koshelok.domain.LoadState
import com.example.koshelok.ui.listwallet.entity.MainScreenDataEntity
import com.example.koshelok.ui.main.appComponent
import com.example.koshelok.ui.util.ErrorHandler
import com.example.koshelok.ui.util.factory.ViewModelFactory
import com.google.android.material.appbar.AppBarLayout
import javax.inject.Inject


@SuppressWarnings("TooManyFunctions")
class ListWalletFragment : Fragment(R.layout.fragment_list_wallet) {

    @Inject
    lateinit var errorHandler: ErrorHandler

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val binding by viewBinding(FragmentListWalletBinding::bind)
    private val walletViewModel: ListWalletViewModel by viewModels { viewModelFactory }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        context.appComponent
            .inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        requireActivity().window.statusBarColor = requireActivity().getColor(R.color.blue)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        walletViewModel.loadMainScreenData()
        with(binding) {
            val walletsAdapter = WalletListAdapter(::transitionToDetailWallet, ::deleteWallet)
            walletList.run {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = walletsAdapter
            }

            addWallet.setOnClickListener {
                launchTitleWalletFragment()
            }

            walletViewModel.mainScreenData.observe(viewLifecycleOwner) { mainScreenEntity ->
                setupMainScreen(mainScreenEntity, walletsAdapter)
                finishButton()
                refreshLayout.isRefreshing = false
            }

            walletViewModel.errorData.observe(viewLifecycleOwner) {
                finishButton()
            }

            walletViewModel.loadStateData.observe(viewLifecycleOwner) { loadState: LoadState ->
                when (loadState) {
                    LoadState.SUCCESS -> {
                        walletViewModel.loadMainScreenData()
                    }
                }
            }

            appBar.addOnOffsetChangedListener(AppBarRefreshListener(refreshLayout))

            refreshLayout.setOnRefreshListener {
                walletViewModel.loadMainScreenData()
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun setupMainScreen(data: MainScreenDataEntity, walletsAdapter: WalletListAdapter) {
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
                    data.balanceEntity.amountMoney + " " + Currency.RUB.icon
                incomeMoney.text =
                    data.balanceEntity.incomeMoney + " " + Currency.RUB.icon
                consumptionMoney.text =
                    data.balanceEntity.consumptionMoney + " " + Currency.RUB.icon
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

    private fun deleteWallet(walletId: Long) {
        AlertDialog.Builder(requireContext())
            .setMessage(requireContext().getString(R.string.you_really_delete_wallet))
            .setPositiveButton(requireContext().getString(R.string.delete_transaction)) { _, _ ->
                walletViewModel.deleteWallet(walletId)
                activeButton()
            }
            .setNegativeButton(requireContext().getString(R.string.cancel)) { dialog, _ ->
                dialog.cancel()
            }
            .show().apply {
                getButton(AlertDialog.BUTTON_POSITIVE)
                    .setTextColor(requireContext().getColor(R.color.red))
                getButton(AlertDialog.BUTTON_NEGATIVE)
                    .setTextColor(requireContext().getColor(R.color.light_blue))
            }
    }

    private fun activeButton() {
        with(binding) {
            progressIndicator.visibility = View.VISIBLE
            buttonText.visibility = View.INVISIBLE
        }
    }

    private fun finishButton() {
        with(binding) {
            progressIndicator.visibility = View.GONE
            buttonText.visibility = View.VISIBLE
        }
    }

    override fun onDestroyView() {
        requireActivity().window.statusBarColor = requireActivity().getColor(R.color.white)
        super.onDestroyView()
    }
}
