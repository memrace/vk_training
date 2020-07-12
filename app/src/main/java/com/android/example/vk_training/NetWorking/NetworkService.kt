package com.android.example.vk_training.NetWorking

import okhttp3.OkHttpClient
import retrofit2.Retrofit

import retrofit2.converter.gson.GsonConverterFactory

//  Singleton
object NetworkService {

    // JSON converter
    private val gsonConverterFactory:GsonConverterFactory = GsonConverterFactory.create()
    //Basic URL
    private const val BASE_URL = "https://api.vk.com/method/"
    // create Retrofit & init
    private lateinit var mRetrofit: Retrofit




    fun getRetrofit (/*client: OkHttpClient*/):Retrofit {

        mRetrofit =  Retrofit.Builder()
//            .client(client)
            .baseUrl(BASE_URL)
            .addConverterFactory(gsonConverterFactory)
            .build()


        return mRetrofit
    }

}



