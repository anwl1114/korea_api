package com.example.api_korea


import com.google.gson.annotations.SerializedName

data class Item(
    @SerializedName("MetalService")
    val metalService: MetalService?
)