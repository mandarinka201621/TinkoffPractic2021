package com.example.koshelok.data.mappers

import com.example.koshelok.data.db.entity.DetailWalletDb
import com.example.koshelok.data.mappers.transactions.TransactionDbToTransactionApiMapper
import com.example.koshelok.data.mappers.wallets.WalletDbToWalletApiMapper
import com.example.koshelok.data.service.api.DetailWalletApi
import javax.inject.Inject

class DetailWalletDbToApiMapper @Inject constructor(
    private val mapperWallet: WalletDbToWalletApiMapper,
    private val transactionApiMapper: TransactionDbToTransactionApiMapper
) : (DetailWalletDb) -> DetailWalletApi {
    override fun invoke(detailWallet: DetailWalletDb): DetailWalletApi {
        return DetailWalletApi(
            mapperWallet(detailWallet.wallet),
            detailWallet.transactions.map(transactionApiMapper)
        )
    }
}
