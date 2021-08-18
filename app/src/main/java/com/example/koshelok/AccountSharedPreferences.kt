package com.example.koshelok

import android.content.SharedPreferences

class AccountSharedPreferences(private val sharedPreferences: SharedPreferences) {

    var email: String
        get() = sharedPreferences.getString(EMAIL_KEY, "").orEmpty()
        set(value) = sharedPreferences.edit().putString(EMAIL_KEY, value).apply()

    private companion object {
        const val EMAIL_KEY = "email_key"
    }
}
