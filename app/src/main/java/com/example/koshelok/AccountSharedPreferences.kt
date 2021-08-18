package com.example.koshelok

import android.content.Context
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey

object AccountSharedPreferences {
    private const val NAME_SHARED_PREF = "name_shared_pref"
    private const val EMAIL_KEY = "email_key"

    fun writeEmail(context: Context, email: String) {
        val sharedPreferences = EncryptedSharedPreferences.create(
            context,
            NAME_SHARED_PREF,
            MasterKey.Builder(context).setKeyScheme(MasterKey.KeyScheme.AES256_GCM).build(),
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )
        sharedPreferences.edit().putString(EMAIL_KEY, email).apply()
    }

    fun readEmail(context: Context):String{
        val sharedPreferences = EncryptedSharedPreferences.create(
            context,
            NAME_SHARED_PREF,
            MasterKey.Builder(context).build(),
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )
        return sharedPreferences.getString(EMAIL_KEY, "")?:""
    }
}
