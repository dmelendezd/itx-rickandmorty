package com.itxtest.rickandmorty.business.model.service.base

import com.itxtest.rickandmorty.business.model.service.constant.NetworkConstants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitProvider {

    val apiService by lazy { getRetrofitApiService() }

    private fun getRetrofitApiService(): RetrofitApiService {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)

        return Retrofit.Builder()
            .baseUrl(NetworkConstants.RICK_MORTY_API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient.Builder().addInterceptor(logging).build())
            .build()
            .create(RetrofitApiService::class.java)
    }
}
