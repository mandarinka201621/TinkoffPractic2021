package com.example.koshelok.domain.usecase

import com.example.koshelok.domain.repository.MainScreenRepository
import com.example.koshelok.ui.listwallet.entity.MainScreenDataEntity
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

interface MainScreenUseCase {
    operator fun invoke(personId: Long): Observable<MainScreenDataEntity>
}

class MainScreenUseCaseImpl @Inject constructor(
    private val mainScreenRepository: MainScreenRepository
) : MainScreenUseCase {

    override fun invoke(personId: Long): Observable<MainScreenDataEntity> {
        return mainScreenRepository.getMainScreenData(personId)
    }
}
