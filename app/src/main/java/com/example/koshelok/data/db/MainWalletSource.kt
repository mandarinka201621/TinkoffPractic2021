package com.example.koshelok.data.db

import com.example.koshelok.data.db.entity.WalletDb
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

interface MainWalletSource {

    fun getMainScreenData(personId: Long): Single<List<WalletDb>>
}

class MainWalletSourceImpl @Inject constructor(
    private val database: KoshelokDatabase
) : MainWalletSource {

    override fun getMainScreenData(personId: Long): Single<List<WalletDb>> {
        return database.getWalletsDao()
            .getWalletByPersonId(personId)
    }
}
