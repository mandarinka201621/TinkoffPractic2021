package com.example.koshelok.di

import android.content.Context
import com.example.koshelok.di.module.BindsRepositoryModule
import com.example.koshelok.di.module.BindsUseCaseModule
import com.example.koshelok.di.module.DatabaseModule
import com.example.koshelok.di.module.NetworkModule
import com.example.koshelok.di.module.SharedPreferencesModule
import com.example.koshelok.di.module.SourceModule
import com.example.koshelok.di.module.ViewModelModule
import dagger.BindsInstance
import dagger.Component

@AppScope
@Component(
    modules = [BindsRepositoryModule::class,
        BindsUseCaseModule::class,
        NetworkModule::class,
        ViewModelModule::class,
        SharedPreferencesModule::class,
        DatabaseModule::class,
        SourceModule::class
    ]
)
interface AppComponent : InjectFragments {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun context(context: Context): Builder

        fun build(): AppComponent
    }
}
