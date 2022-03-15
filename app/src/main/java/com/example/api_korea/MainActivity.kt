package com.example.api_korea

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.api_korea.data.Item
import com.example.api_korea.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val koreaadapter by lazy {
        KoreaAdapter()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.recyclerview.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = koreaadapter
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        }
        KoreaapiWork()
    }

    private fun KoreaapiWork() {
        val service = KoreaClient.koreaInterface
        service.getKoreaData(getString(R.string.apikey), 1,10,"json", "20210828", "1","90303", "RH02")
            .enqueue(object : Callback<Item> {
                override fun onResponse(
                    call: Call<Item>,
                    response: Response<Item>
                ) {
                    if (response.isSuccessful) {
//                        Log.d("성공", response.body().toString())
                        val result = response.body()?.metalService?.get(1).row
                        koreaadapter.submitList(result!!)
                    }
                }
                override fun onFailure(call: Call<Item>, t: Throwable) {
                    Log.d("실패", t.message.toString())
                }
            })
    }
}