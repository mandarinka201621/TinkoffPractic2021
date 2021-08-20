package com.example.koshelok.ui.detailwallet

import android.app.AlertDialog
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.koshelok.R
import com.example.koshelok.databinding.FragmentDetailWalletBinding

class DetailWalletFragment : Fragment(R.layout.fragment_detail_wallet),OptionsCallback{
    private val binding by viewBinding(FragmentDetailWalletBinding::bind)
    private val viewModel: DetailWalletViewModel by viewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            toolbar.inflateMenu(R.menu.menu_detail_wallet)
            toolbar.setNavigationOnClickListener {
                requireActivity().onBackPressed()
            }
            val detailWalletAdapter = DetailWalletAdapter(this@DetailWalletFragment)
            addOperation.setOnClickListener {
                //TODO сделать переход на следюущий экран
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
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.settingsButton -> {
                //TODO сделать кнопку настроек
            }
        }
        return true
    }

    override fun deleteTransaction(data: DetailWalletItem.Transaction) {
        val builder = AlertDialog.Builder(requireContext())
        builder.setMessage(requireContext().getString(R.string.you_really_delete_transaction))
            .setPositiveButton(requireContext().getString(R.string.delete_transaction)) { _, _ ->
                viewModel.deleteTransaction(data)
            }
            .setNegativeButton(requireContext().getString(R.string.cancel)) { dialog, _ ->
                dialog.cancel()
            }
            .create().show()
    }

    override fun editTransaction(data: DetailWalletItem.Transaction) {
        //TODO сделать переход на следюущий экран
    }
}
