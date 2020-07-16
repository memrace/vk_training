package com.android.example.vk_training.NetWorking.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class VkResponse(
    @SerializedName("response")
    @Expose
    val response:List<DataVK>
)



data class DataVK(
    @SerializedName("id")
    @Expose
    val id:Int,
    @SerializedName("first_name")
    @Expose
    val first_name:String,
    @SerializedName("last_name")
    @Expose
    val last_name:String,
    @SerializedName("is_closed")
    @Expose
    val is_closed:Boolean,
    @SerializedName("can_access_closed")
    @Expose
    val can_access_closed:Boolean)