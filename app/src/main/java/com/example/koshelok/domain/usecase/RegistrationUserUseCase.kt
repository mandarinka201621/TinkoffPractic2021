package com.example.koshelok.domain.usecase

import com.example.koshelok.domain.repository.RegistrationRepository
import com.example.koshelok.ui.onboarding.UserEntity
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

interface RegistrationUserUseCase {
    operator fun invoke(user: UserEntity): Single<Long>
}

class RegistrationUserUseCaseImpl @Inject constructor(
    private val registrationRepository: RegistrationRepository
) : RegistrationUserUseCase {

    override fun invoke(user: UserEntity): Single<Long> {
        return registrationRepository.registrationUser(user)
    }
}
