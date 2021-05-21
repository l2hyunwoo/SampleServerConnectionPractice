package com.nunu.simpleserverconnection.data

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitObject {
    private const val GITHUB_BASE_URL = "https://api.github.com/"
    private fun provideLoggingInterceptor() =
        HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }

    private fun provideClient() = OkHttpClient.Builder()
        .addInterceptor(provideLoggingInterceptor())
        .build()

    private fun provideRetrofitObject(): Retrofit {
        return Retrofit.Builder().baseUrl(GITHUB_BASE_URL).client(provideClient())
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    val GITHUB_SERVICE = provideRetrofitObject().create(GithubService::class.java)
}
