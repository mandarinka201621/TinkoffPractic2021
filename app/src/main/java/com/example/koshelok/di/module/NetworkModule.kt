package com.example.koshelok.di.module

import com.example.koshelok.data.service.AppApi
import com.example.koshelok.di.AppScope
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

private const val BASE_URL = "https://api.github.com/"

@ExperimentalSerializationApi
@Module
class NetworkModule {

    private val contentType = "application/json".toMediaType()

    @Provides
    fun providesRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(Json.asConverterFactory(contentType))
            .baseUrl(BASE_URL).build()
    }

    @AppScope
    @Provides
    fun providesGithubApi(retrofit: Retrofit): AppApi {
        return retrofit.create(AppApi::class.java)
    }
}
