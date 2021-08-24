package com.example.koshelok.di.module

import com.example.koshelok.MockServer
import com.example.koshelok.data.service.AppService
import com.example.koshelok.di.AppScope
import com.example.koshelok.di.Prod
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Converter
import retrofit2.Retrofit

private const val BASE_URL = "https://http://34.88.54.200:9090/"

@ExperimentalSerializationApi
@Module
class NetworkModule {

    private val contentType = "application/json".toMediaType()

    @Provides
    fun provideConverterFactory():Converter.Factory{
        return Json.asConverterFactory(contentType)
    }

    @Provides
    fun providesRetrofit(converterFactory: Converter.Factory): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(converterFactory)
            .baseUrl(BASE_URL).build()
    }

    @AppScope
    @Provides
    fun providesGithubApi(retrofit: Retrofit): AppService {
        return retrofit.create(AppService::class.java)
    }

    @Prod
    @AppScope
    @Provides
    fun providesMockServer(mockServer: MockServer): AppService {
        return mockServer
    }
}
