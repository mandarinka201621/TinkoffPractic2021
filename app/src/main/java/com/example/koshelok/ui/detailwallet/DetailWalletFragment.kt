package com.example.koshelok.ui.detailwallet

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.koshelok.R
import com.example.koshelok.databinding.FragmentDetailWalletBinding
import com.example.koshelok.domain.LoadState
import com.example.koshelok.ui.main.appComponent
import com.example.koshelok.ui.util.ErrorHandler
import com.example.koshelok.ui.util.entity.TransactionEntity
import com.example.koshelok.ui.util.factory.ViewModelFactory
import javax.inject.Inject

class DetailWalletFragment : Fragment(R.layout.fragment_detail_wallet), SwipeOptionsCallback {

    @Inject
    lateinit var errorHandler: ErrorHandler

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val binding by viewBinding(FragmentDetailWalletBinding::bind)
    private val viewModel: DetailWalletViewModel by viewModels { viewModelFactory }
    private val args by navArgs<DetailWalletFragmentArgs>()
    private val walletId by lazy { args.walletId }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        context.appComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.loadWalletData(walletId = walletId)
        with(binding) {
            setOnBackPressedListener()

            toolbar.inflateMenu(R.menu.menu_detail_wallet)
            toolbar.setNavigationOnClickListener {
                findNavController().popBackStack(R.id.walletListFragment, false)
            }
            val detailWalletAdapter = DetailWalletAdapter(this@DetailWalletFragment)
            addOperation.setOnClickListener {
                launchTypeFragment()
            }
            detailWalletList.run {
                adapter = detailWalletAdapter
                layoutManager = LinearLayoutManager(requireContext())
            }

            viewModel.detailWalletData.observe(viewLifecycleOwner) { detailWallet ->
                detailWalletAdapter.setData(detailWallet)
                emptyNotes.visibility =
                    if (detailWallet.size <= 1) View.VISIBLE else View.GONE
                detailWalletList.scrollToPosition(0)
                refreshLayout.isRefreshing = false
            }

            viewModel.loadStateData.observe(viewLifecycleOwner) { loadState: LoadState ->
                when (loadState) {
                    LoadState.SUCCESS -> viewModel.loadWalletData(walletId)
                }
                refreshLayout.isRefreshing = false
            }

            viewModel.errorData.observe(viewLifecycleOwner) { throwable ->
                refreshLayout.isRefreshing = false
                errorHandler.createErrorToastBar(throwable, layoutInflater)
            }

            refreshLayout.setOnRefreshListener {
                viewModel.loadWalletData(walletId)
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    findNavController().popBackStack(R.id.walletListFragment, false)
                }
            })
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.settingsButton -> {
                //TODO сделать кнопку настроек
            }
        }
        return true
    }

    private fun launchTypeFragment() {
        findNavController().navigate(
            DetailWalletFragmentDirections.actionDetailWalletFragmentToSumOperationFragment(
                TransactionEntity(null, walletId, null, null, null, null)
            )
        )
    }

    private fun setOnBackPressedListener() {
        binding.toolbar.setNavigationOnClickListener {
            findNavController().popBackStack(R.id.walletListFragment, false)
        }
    }

    override fun deleteTransaction(data: DetailWalletItem.Transaction) {
        AlertDialog.Builder(requireContext())
            .setMessage(requireContext().getString(R.string.you_really_delete_transaction))
            .setPositiveButton(requireContext().getString(R.string.delete_transaction)) { _, _ ->
                viewModel.deleteTransaction(data)
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

    override fun editTransaction(data: DetailWalletItem.Transaction) {
        //TODO сделать переход на следюущий экран
    }
}
