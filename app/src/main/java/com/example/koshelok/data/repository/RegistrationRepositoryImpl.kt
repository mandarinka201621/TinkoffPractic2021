package com.example.koshelok.data.repository

import com.example.koshelok.data.service.AppService
import com.example.koshelok.domain.repository.RegistrationRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class RegistrationRepositoryImpl @Inject constructor(
    private val appService: AppService
) : RegistrationRepository {

    override fun registrationUser(email: String): Single<Long> {
        return appService.registrationUser(email)
    }
}
