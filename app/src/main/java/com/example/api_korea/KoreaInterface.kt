package com.example.api_korea

import com.example.api_korea.data.Item
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface KoreaInterface {
    @GET("MetalService?serviceKey=Qqpcpx3goLGt5I9rRel4740aHPeckfo48EhDQ1c4pFjLIzKv%2FvXjDrGskdQdoYxZNpdPbrg0u8w6C4datQphPw%3D%3D")
    fun loadNotion(@Query("page")page: String) : Call<Item>
}