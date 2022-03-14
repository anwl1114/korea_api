package com.example.api_korea

import com.example.api_korea.data.Item
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface KoreaInterface {
    @GET("MetalService")
    fun getKoreaData (@Query("serviceKey")serviceKey : String,
                      @Query("resultType")resultType:String) : Call<Item>
}