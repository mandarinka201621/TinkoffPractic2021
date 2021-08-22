package com.example.koshelok.data.service.repimpl

import com.example.koshelok.data.service.AppApi
import com.example.koshelok.data.service.Mapper
import com.example.koshelok.domain.repository.ListWalletRepository
import com.example.koshelok.ui.listwallet.entity.BalanceEntity
import com.example.koshelok.ui.listwallet.entity.ExchangeRatesEntity
import com.example.koshelok.ui.listwallet.entity.WalletEntity
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class ListWalletRepositoryImpl @Inject constructor(
    private val mapper: Mapper,
    private val appApi: AppApi
) : ListWalletRepository {
    override fun getExchangeRates(): Single<ExchangeRatesEntity> {
        return appApi.getExchangeRates().map {
            mapper.mapExchangeRatesApiToExchangeRatesEntity(it)
        }
    }

    override fun getBalance(): Single<BalanceEntity> {
        return appApi.getBalance().map {
            mapper.mapBalanceApiToBalanceEntity(it)
        }
    }

    override fun getListWallet(): Single<List<WalletEntity>> {
        return appApi.getWallets()
            .map { wallets ->
                wallets.map { walletApi -> mapper.mapWalletApiToWalletEntity(walletApi) }
            }
    }
}
