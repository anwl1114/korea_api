package com.example.api_korea.data

import com.google.gson.annotations.SerializedName

data class Item(val item: ArrayList<ItemList>)

data class ItemList(
    @SerializedName("SDATE")
    val sdate: Int,    @SerializedName("STATIONCODE")
    val stationcode: Int,
    @SerializedName("ITEMCODE")
    val itemcode: Int,
    @SerializedName("TIMECODE")
    val timecode : String,
//    @SerializedName("VALUE")
//    val value : Float
    )


