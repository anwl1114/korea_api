package com.example.api_korea

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object KoreaClient {
    private const val baseUrl = "http://apis.data.go.kr/1480523/MetalMeasuringResultService/"
    private val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service = retrofit.create(KoreaInterface::class.java)!!
}