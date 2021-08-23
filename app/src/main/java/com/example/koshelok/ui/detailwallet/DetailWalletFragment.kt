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
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.koshelok.R
import com.example.koshelok.data.factory.ViewModelFactory
import com.example.koshelok.databinding.FragmentDetailWalletBinding
import com.example.koshelok.ui.appComponent
import com.example.koshelok.ui.model.Transaction
import javax.inject.Inject

class DetailWalletFragment : Fragment(R.layout.fragment_detail_wallet), SwipeOptionsCallback {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val binding by viewBinding(FragmentDetailWalletBinding::bind)
    private val viewModel: DetailWalletViewModel by viewModels { viewModelFactory }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        context.appComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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
            viewModel.getData().observe(viewLifecycleOwner) { data: List<DetailWalletItem>? ->
                if (data != null) {
                    detailWalletAdapter.setData(data)
                    emptyNotes.visibility = if (data.size <= 1) View.VISIBLE else View.GONE
                }
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
                Transaction(0, null, null, null, null)
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
            .create().apply {
                show()
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
