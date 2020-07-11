package com.android.example.vk_training.NetWorking.data

import com.google.gson.annotations.SerializedName

data class DataVK(
    @SerializedName("id")
    val id:Int,
    @SerializedName("first_name")
    val f_Name:String,
    @SerializedName("last_name")
    val l_name:String)