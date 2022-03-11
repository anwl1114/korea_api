package com.example.api_korea.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.util.Log
import android.widget.Toast
import com.example.api_korea.databinding.ActivityMainBinding
import com.example.api_korea.repository.KoreaRepository
import com.google.android.gms.drive.events.CompletionListener

class MainActivity() : AppCompatActivity(), CompletionListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var notionAdapter: NotionAdapter
    private val koreaRepository = KoreaRepository()
    private var page = 1

    constructor(parcel: Parcel) : this() {
        page = parcel.readInt()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    override fun loadComplete(data: Data) {
        NotionAdapter.setList(data.content)
    }

    override fun loadFail() {
        Toast.makeText(this, "인터넷 연결을 확인하세요", Toast.LENGTH_SHORT).show()
    }



   override fun responseIsNotSuccesful(code :Int) {
        Toast.makeText(this, "사이트가 응답하지 않습니다", Toast.LENGTH_SHORT).show()
        Log.v("log", code.toString())
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(page)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MainActivity> {
        override fun createFromParcel(parcel: Parcel): MainActivity {
            return MainActivity(parcel)
        }

        override fun newArray(size: Int): Array<MainActivity?> {
            return arrayOfNulls(size)
        }
    }


}