package com.example.api_korea.data


import com.google.gson.annotations.SerializedName

data class Item(
    @SerializedName("MetalService")
    val metalService: MetalService?
)

data class Header(
    @SerializedName("code")
    val code: String?,
    @SerializedName("message")
    val message: String?
)

data class ItemX(
    @SerializedName("SDATE")
    val sDATE: String?, //20171208000000
    @SerializedName("STATIONCODE")
    val sTATIONCODE: Int?, //1
    @SerializedName("ITEMCODE")
    val iTEMCODE: String?, //90303  90319: 칼슘 / 90303: 납
    @SerializedName("TIMECODE")
    val tIMECODE: String?, //RH02   RH24 : 24시간이동 평균 / RH02 : 2시간 이동 평균
    @SerializedName("VALUE")
    val vALUE: Double? //24.126
)

data class MetalService(
    @SerializedName("header")
    val header: Header?,
    @SerializedName("item")
    val item: List<ItemX>?,
    @SerializedName("numOfRows")
    val numOfRows: Int?,
    @SerializedName("pageNo")
    val pageNo: Int?,
    @SerializedName("rows")
    val rows: Any?,
    @SerializedName("totalCount")
    val totalCount: Int?
)

