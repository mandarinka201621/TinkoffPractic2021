package com.example.koshelok.di

import android.content.Context
import com.example.koshelok.di.module.AppModule
import dagger.BindsInstance
import dagger.Component

@AppScope
@Component(
    modules = [AppModule::class])
interface AppComponent: InjectFragments {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun context(context: Context): Builder

        fun build(): AppComponent
    }
}
