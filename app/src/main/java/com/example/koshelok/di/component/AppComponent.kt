package com.example.koshelok.di.component

import android.content.Context
import com.example.koshelok.di.AppScope
import com.example.koshelok.di.module.AppModule
import com.example.koshelok.ui.onboarding.OnBoardingScreenFragment
import dagger.BindsInstance
import dagger.Component

@AppScope
@Component(
    modules = [AppModule::class])
interface AppComponent {

    fun inject(onBoardingScreenFragment: OnBoardingScreenFragment)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun context(context: Context): Builder

        fun build(): AppComponent
    }
}
