package com.example.koshelok.data.repository

import com.example.koshelok.data.mappers.UserEntityToUserApiMapper
import com.example.koshelok.data.service.AppService
import com.example.koshelok.domain.repository.RegistrationRepository
import com.example.koshelok.ui.onboarding.UserEntity
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class RegistrationRepositoryImpl @Inject constructor(
    private val appService: AppService,
    private val userApiMapper: UserEntityToUserApiMapper
) : RegistrationRepository {

    override fun registrationUser(user: UserEntity): Single<Long> {
        return appService.registrationUser(userApiMapper(user))
    }
}
