package com.emirk.imdbexample.di.network

import android.util.Log
import com.emirk.imdbexample.data.remote.ApiService
import com.emirk.imdbexample.data.remote.util.ApiConstants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor { message ->
            try {
                val jsonObject = JSONObject(message)
                Log.d("API_RESPONSE", jsonObject.toString(4))
            } catch (e: JSONException) {
                Log.e("API_RESPONSE", message)
            }
        }.apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        val requestInterceptor = Interceptor { chain ->
            val request = chain.request()
            val requestBody = request.body
            val bodyString = requestBody?.let { requestBody }
            Log.d("API_REQUEST", "URL: ${request.url}\nBody: $bodyString")
            chain.proceed(request)
        }

        return OkHttpClient.Builder()
            .addInterceptor(requestInterceptor)
            .addInterceptor(loggingInterceptor)
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(
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
    fun provideApiService(
        retrofit: Retrofit
    ): ApiService {
        return retrofit.create(ApiService::class.java)
    }

}