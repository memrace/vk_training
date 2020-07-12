package com.android.example.vk_training.NetWorking.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class DataVK(
    @SerializedName("id")
    @Expose
    val id:Int,
    @SerializedName("first_name")
    @Expose
    val f_Name:String,
    @SerializedName("last_name")
    @Expose
    val l_name:String)