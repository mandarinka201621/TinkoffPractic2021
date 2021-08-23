package com.example.koshelok.di

import android.app.Application
import com.example.koshelok.di.module.AppModule
import dagger.BindsInstance
import dagger.Component

@AppScope
@Component(
    modules = [BindsModule::class,
        NetworkModule::class,
        ViewModelModule::class,
        SharedPreferencesModule::class
    ]
)
interface AppComponent : InjectFragments {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun context(app:Application): Builder

        fun build(): AppComponent
    }
}
