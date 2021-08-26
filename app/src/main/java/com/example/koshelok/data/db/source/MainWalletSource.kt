package com.example.koshelok.data.db.source

import com.example.koshelok.data.db.KoshelokDatabase
import com.example.koshelok.data.mappers.MainScreenDataDbToApiMapper
import com.example.koshelok.data.mappers.balance.StringsDataToBalanceDbMapper
import com.example.koshelok.data.mappers.exchangerates.ExchangeRatesApiToDbMapper
import com.example.koshelok.data.mappers.wallets.WalletApiToWalletDbMapper
import com.example.koshelok.data.service.api.MainScreenDataApi
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

interface MainWalletSource {

    fun getMainScreenData(personId: Long): Single<MainScreenDataApi>

    fun insertMainScreenData(
        personId: Long,
        mainScreenDataApi: MainScreenDataApi
    )
}

class MainWalletSourceImpl @Inject constructor(
    private val database: KoshelokDatabase,
    private val balanceMapper: StringsDataToBalanceDbMapper,
    private val exchangeRatesMapper: ExchangeRatesApiToDbMapper,
    private val walletDbMapper: WalletApiToWalletDbMapper,
    private val mainScreenMapper: MainScreenDataDbToApiMapper
) : MainWalletSource {

    override fun getMainScreenData(personId: Long): Single<MainScreenDataApi> {
        return database.getMainScreenDao()
            .getMainScreenData(personId)
            .map(mainScreenMapper)
    }

    override fun insertMainScreenData(
        personId: Long,
        mainScreenDataApi: MainScreenDataApi
    ) {
        database.getMainScreenDao().insertMainScreenData(
            balanceMapper(
                personId,
                mainScreenDataApi.balance,
                mainScreenDataApi.income,
                mainScreenDataApi.consumption
            ),
            exchangeRatesMapper(personId, mainScreenDataApi.exchangeRatesApi),
            mainScreenDataApi.wallets.map(walletDbMapper)
        )
    }
}
