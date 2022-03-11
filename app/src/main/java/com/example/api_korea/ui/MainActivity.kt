package com.example.api_korea.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.api_korea.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun loadComplete(data: Data) {
        noti
    }
}