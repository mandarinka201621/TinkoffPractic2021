package com.example.koshelok.domain.usecase

import com.example.koshelok.domain.repository.RegistrationRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

interface RegistrationUserUseCase {
    operator fun invoke(email: String): Single<Long>
}

class RegistrationUserUseCaseImpl @Inject constructor(
    private val registrationRepository: RegistrationRepository
) : RegistrationUserUseCase {

    override fun invoke(email: String): Single<Long> {
        return registrationRepository.registrationUser(email)
    }
}
