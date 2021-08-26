package com.example.koshelok.data.repository

import com.example.koshelok.data.db.source.MainWalletSource
import com.example.koshelok.data.mappers.MainScreenDataApiToEntityMapper
import com.example.koshelok.data.service.AppService
import com.example.koshelok.domain.repository.MainScreenRepository
import com.example.koshelok.ui.listwallet.entity.MainScreenDataEntity
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

class MainScreenRepositoryImpl @Inject constructor(
    private val mapper: MainScreenDataApiToEntityMapper,
    private val appService: AppService,
    private val mainWalletSource: MainWalletSource,
) : MainScreenRepository {

    override fun getMainScreenData(personId: Long): Observable<MainScreenDataEntity> {
        return Observable.create { emitter ->
            mainWalletSource.getMainScreenData(personId)
                .flatMap { wallet ->
                    emitter.onNext(mapper(wallet))
                    appService.getDataForMainScreen(personId)
                        .doOnSuccess {
                            mainWalletSource.insertMainScreenData(personId, it)
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
