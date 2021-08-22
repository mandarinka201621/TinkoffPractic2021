package com.example.koshelok.di.module

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.example.koshelok.data.factory.EncryptedSharedPreferencesFactory
import dagger.Module
import dagger.Provides

@Module(
    includes = [BindsModule::class, NetworkModule::class, ViewModelModule::class]
)
class AppModule {

    @Provides
    fun provideContext(app:Application):Context{
        return app.applicationContext
    }

    @Provides
    fun provideSharedPref(
        encryptedSharedPreferencesFactory: EncryptedSharedPreferencesFactory
    ): SharedPreferences {
        return encryptedSharedPreferencesFactory.create()
    }
}
