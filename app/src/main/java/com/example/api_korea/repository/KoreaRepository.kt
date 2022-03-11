package com.example.api_korea.repository

import com.example.api_korea.KoreaClient
import com.example.api_korea.ui.MainActivity
import com.example.api_korea.data.Item
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class KoreaRepository {
    fun loadKoreaNotice(page: Int, mCallback: MainActivity) {
        val call = KoreaClient.service.loadNotion(page.toString())

        call.enqueue(object : Callback<Item> {
            override fun onResponse(
                call: Call<Item>,
                response: Response<Item>
            ) {
                if(response.isSuccessful) {
                    mCallback.loadComplete(response.body().data)
                }
            }

            override fun onFailure(call: Call<Item>, t: Throwable) {

            }
        })
    }
}