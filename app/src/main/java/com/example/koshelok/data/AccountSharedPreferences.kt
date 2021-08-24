package com.example.koshelok.data

import android.content.SharedPreferences
import javax.inject.Inject

class AccountSharedPreferences @Inject constructor(private val sharedPreferences: SharedPreferences) {

    var email: String
        get() = sharedPreferences.getString(EMAIL_KEY, "").orEmpty()
        set(value) = sharedPreferences.edit().putString(EMAIL_KEY, value).apply()

    var personId: Long
        get() = sharedPreferences.getLong(PERSON_ID_KEY, 0)
        set(value) = sharedPreferences.edit().putLong(PERSON_ID_KEY, value).apply()

    private companion object {
        const val EMAIL_KEY = "email_key"
        const val PERSON_ID_KEY = "person_id_key"
    }
}
