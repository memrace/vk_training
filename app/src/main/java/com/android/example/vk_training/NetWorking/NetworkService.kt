package com.android.example.vk_training.NetWorking

import com.android.example.vk_training.NetWorking.data.DataVK
import kotlinx.coroutines.Deferred
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

//  Singleton
object NetworkService {

    // JSON converter
    private val gsonConverterFactory:GsonConverterFactory = retrofit2.converter.gson.GsonConverterFactory.create()
    //Basic URL
    private const val BASE_URL = "https://api.vk.com/method/"
    // create Retrofit & init
    private lateinit var mRetrofit: Retrofit


    // method  to back var  mInstance

    fun getRetrofit (client: OkHttpClient):Retrofit {

        mRetrofit =  Retrofit.Builder()
            .client(client)
            .baseUrl(BASE_URL)
            .addConverterFactory(gsonConverterFactory)
            .build()


        return mRetrofit
    }

}

