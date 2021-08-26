package com.example.koshelok.data.repository

import com.example.koshelok.data.db.MainWalletSource
import com.example.koshelok.data.db.WalletSource
import com.example.koshelok.data.mappers.MainScreenDataApiToEntityMapper
import com.example.koshelok.data.mappers.WalletApiToWalletEntityMapper
import com.example.koshelok.data.mappers.WalletDbToWalletApiMapper
import com.example.koshelok.data.service.AppService
import com.example.koshelok.domain.Currency
import com.example.koshelok.domain.repository.MainScreenRepository
import com.example.koshelok.ui.listwallet.entity.BalanceEntity
import com.example.koshelok.ui.listwallet.entity.ExchangeRatesEntity
import com.example.koshelok.ui.listwallet.entity.MainScreenDataEntity
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

class MainScreenRepositoryImpl @Inject constructor(
    private val mapper: MainScreenDataApiToEntityMapper,
    private val walletDbMapper: WalletDbToWalletApiMapper,
    private val walletApiToWalletEntityMapper: WalletApiToWalletEntityMapper,
    private val appService: AppService,
    private val mainWalletSource: MainWalletSource,
    private val walletSource: WalletSource,
) : MainScreenRepository {

    override fun getMainScreenData(personId: Long): Observable<MainScreenDataEntity> {
        return Observable.create { emitter ->
            mainWalletSource.getMainScreenData(personId)
                .flatMap { wallet ->
                    emitter.onNext(
                        MainScreenDataEntity(
                            BalanceEntity("100", "200", "100"),
                            ExchangeRatesEntity(
                                Currency.USD,
                                "90,22",
                                true,
                                Currency.EUR,
                                "12,31",
                                true,
                                Currency.GBR,
                                "199,12",
                                true
                            ),
                            wallet.map { walletApiToWalletEntityMapper(walletDbMapper(it)) }
                        )
                    )
                    appService.getDataForMainScreen(personId)
                        .doOnSuccess {
                            walletSource.insertAllWallets(it.wallets)
                        }
                        .map(mapper)
                }
                .subscribe({ mainScreenData ->
                    emitter.onNext(mainScreenData)
                }, {
                    emitter.onError(it)
                }
                )
        }
    }
}
