package com.example.koshelok.domain.repository

import com.example.koshelok.ui.MainScreenDataEntity
import io.reactivex.rxjava3.core.Single

interface MainScreenRepository {

    fun getMainScreenData(personId: Long): Single<MainScreenDataEntity>
}
