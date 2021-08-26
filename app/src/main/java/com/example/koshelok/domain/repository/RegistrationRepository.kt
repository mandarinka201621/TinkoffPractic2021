package com.example.koshelok.domain.repository

import com.example.koshelok.ui.onboarding.UserEntity
import io.reactivex.rxjava3.core.Single

interface RegistrationRepository {

    fun registrationUser(user: UserEntity): Single<Long>
}
