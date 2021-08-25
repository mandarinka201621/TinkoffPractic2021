package com.example.koshelok.data.repository

import com.example.koshelok.data.mappers.MainScreenDataApiToEntityMapper
import com.example.koshelok.data.service.AppService
import com.example.koshelok.domain.repository.MainScreenRepository
import com.example.koshelok.ui.listwallet.entity.MainScreenDataEntity
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class MainScreenRepositoryImpl @Inject constructor(
    private val mapper: MainScreenDataApiToEntityMapper,
    private val appService: AppService
) : MainScreenRepository {

    override fun getMainScreenData(personId: Long): Single<MainScreenDataEntity> {
        return appService.getDataForMainScreen(personId)
            .map(mapper)
    }
}
