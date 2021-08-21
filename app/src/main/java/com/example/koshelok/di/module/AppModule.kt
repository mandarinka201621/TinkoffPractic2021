package com.example.koshelok.di.module

import android.content.SharedPreferences
import com.example.koshelok.EncryptedSharedPreferencesFactory
import dagger.Module
import dagger.Provides

@Module(
    includes = [BindsModule::class, NetworkModule::class])
class AppModule {

    @Provides
    fun provideSharedPref(
        encryptedSharedPreferencesFactory: EncryptedSharedPreferencesFactory
    ): SharedPreferences {
        return encryptedSharedPreferencesFactory.create()
    }
}
