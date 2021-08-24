package com.example.koshelok.domain.usecase

import com.example.koshelok.domain.repository.MainScreenRepository
import com.example.koshelok.ui.MainScreenDataEntity
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

interface MainScreenUseCase {
    operator fun invoke(personId: Long): Single<MainScreenDataEntity>
}

class MainScreenUseCaseImpl @Inject constructor(
    private val mainScreenRepository: MainScreenRepository
) : MainScreenUseCase {

    override fun invoke(personId: Long): Single<MainScreenDataEntity> {
        return mainScreenRepository.getMainScreenData(personId)
    }
}
