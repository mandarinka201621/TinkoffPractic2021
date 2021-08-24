package com.example.koshelok.domain.repository

import io.reactivex.rxjava3.core.Single

interface RegistrationRepository {

    fun registrationUser(email: String): Single<Long>
}
