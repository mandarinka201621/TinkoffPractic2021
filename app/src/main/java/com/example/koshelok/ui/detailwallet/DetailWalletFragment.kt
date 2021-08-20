package com.example.koshelok.ui.detailwallet

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.koshelok.R
import com.example.koshelok.databinding.FragmentDetailWalletBinding

class DetailWalletFragment : Fragment(R.layout.fragment_detail_wallet) {
    private val binding by viewBinding(FragmentDetailWalletBinding::bind)
    private val viewModel: DetailWalletViewModel by viewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            toolbar.inflateMenu(R.menu.menu_detail_wallet)
            toolbar.setNavigationOnClickListener {
                requireActivity().onBackPressed()
            }
            val detailWalletAdapter = DetailWalletAdapter()
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
}
