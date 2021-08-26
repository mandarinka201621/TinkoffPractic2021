package com.example.koshelok.domain.repository

import com.example.koshelok.ui.listwallet.entity.MainScreenDataEntity
import io.reactivex.rxjava3.core.Observable

interface MainScreenRepository {

    fun getMainScreenData(personId: Long): Observable<MainScreenDataEntity>
}
