package com.emirk.imdbexample.di.network

import com.emirk.imdbexample.BuildConfig
import com.emirk.imdbexample.data.remote.ApiService
import com.emirk.imdbexample.data.remote.util.ApiConstants
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

object NetworkModule {

    @Singleton
    @Provides
    fun provideConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        val httpClient = OkHttpClient.Builder().addInterceptor { chain ->
            val original = chain.request()

            // Add API key to the request
            val requestBuilder = original.newBuilder()
                .url(
                    original.url.newBuilder()
                    .addQueryParameter("api_key", BuildConfig.API_KEY)
                    .build())
                .method(original.method, original.body)

            val request = requestBuilder.build()
            chain.proceed(request)
        }.build()

        return httpClient
    }

    @Singleton
    @Provides
    fun provideRetrofitAPI(
        gsonConverterFactory: GsonConverterFactory,
        okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(ApiConstants.BASE_URL)
            .addConverterFactory(gsonConverterFactory)
            .client(okHttpClient)
            .build()
    }

    @Singleton
    @Provides
    fun provideApiFactory(
        retrofit: Retrofit
    ): ApiService {
        return retrofit.create(ApiService::class.java)
    }
}