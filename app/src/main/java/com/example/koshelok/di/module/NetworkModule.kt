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
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory

private const val BASE_URL = "http://34.88.54.200:9090/"

@ExperimentalSerializationApi
@Module
class NetworkModule {

    private val contentType = "application/json".toMediaType()

    private val json = Json {
        ignoreUnknownKeys = true
    }

    @Provides
    fun provideConverterFactory(): Converter.Factory {
        return json.asConverterFactory(contentType)
    }

    @Provides
    fun providesLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    @Provides
    fun providesHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }


    @Provides
    fun providesRetrofit(converterFactory: Converter.Factory, client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(client)
            .addConverterFactory(converterFactory)
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
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

