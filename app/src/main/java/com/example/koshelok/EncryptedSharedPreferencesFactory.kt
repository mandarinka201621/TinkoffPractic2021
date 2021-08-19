package com.example.koshelok

import android.content.Context
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey

class EncryptedSharedPreferencesFactory {

    fun create(context: Context): SharedPreferences = EncryptedSharedPreferences.create(
        context,
        NAME_SHARED_PREF,
        MasterKey.Builder(context).setKeyScheme(MasterKey.KeyScheme.AES256_GCM).build(),
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
    )

    private companion object{
        const val NAME_SHARED_PREF = "name_shared_pref"
    }
}
