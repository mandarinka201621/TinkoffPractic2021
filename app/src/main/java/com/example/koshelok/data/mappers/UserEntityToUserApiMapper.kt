package com.example.koshelok.data.mappers

import com.example.koshelok.data.service.api.UserApi
import com.example.koshelok.ui.onboarding.UserEntity
import javax.inject.Inject

class UserEntityToUserApiMapper @Inject constructor() : (UserEntity) -> UserApi {

    override fun invoke(user: UserEntity): UserApi {
        return UserApi(
            user.id,
            user.email
        )
    }
}
