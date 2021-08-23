package com.example.koshelok.di

import android.content.Context
import com.example.koshelok.di.module.BindsModule
import com.example.koshelok.di.module.NetworkModule
import com.example.koshelok.di.module.SharedPreferencesModule
import com.example.koshelok.di.module.ViewModelModule
import dagger.BindsInstance
import dagger.Component

@AppScope
@Component(
    modules = [BindsModule::class, NetworkModule::class, ViewModelModule::class,
        SharedPreferencesModule::class])
interface AppComponent: InjectFragments {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun context(context: Context): Builder

        fun build(): AppComponent
    }
}
