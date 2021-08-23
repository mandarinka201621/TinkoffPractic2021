package com.example.koshelok.data.repository

import com.example.koshelok.data.mappers.BalanceApiToBalanceEntityMapper
import com.example.koshelok.data.mappers.ExchangeRatesApiToExchangeRatesEntityMapper
import com.example.koshelok.data.mappers.WalletApiToWalletEntityMapper
import com.example.koshelok.data.service.AppService
import com.example.koshelok.domain.repository.ListWalletRepository
import com.example.koshelok.ui.listwallet.entity.BalanceEntity
import com.example.koshelok.ui.listwallet.entity.ExchangeRatesEntity
import com.example.koshelok.ui.listwallet.entity.WalletEntity
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class ListWalletRepositoryImpl @Inject constructor(
    private val mapperWallet: WalletApiToWalletEntityMapper,
    private val mapperExchangeRates: ExchangeRatesApiToExchangeRatesEntityMapper,
    private val mapperBalance: BalanceApiToBalanceEntityMapper,
    private val appService: AppService
) : ListWalletRepository {
    override fun getExchangeRates(): Single<ExchangeRatesEntity> {
        return appService.getExchangeRates().map {
            mapperExchangeRates(it)
        }
    }

    override fun getBalance(personId: Long): Single<BalanceEntity> {
        return appService.getBalance(personId).map {
            mapperBalance(it)
        }
    }

    override fun getListWallet(personId: Long): Single<List<WalletEntity>> {
        return appService.getWallets(personId)
            .map { wallets ->
                wallets.map { walletApi -> mapperWallet(walletApi) }
            }
    }
}
