package com.example.api_korea

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object KoreaClient {
    private const val baseUrl = "http://apis.data.go.kr/1480523/MetalMeasuringResultService/"

    private val okhttpclient : OkHttpClient by lazy {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }) .build()
    }

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okhttpclient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val koreaInterface = retrofit.create(KoreaInterface::class.java)

}

