package com.android.example.vk_training.NetWorking

import com.android.example.vk_training.NetWorking.data.DataVK
import com.android.example.vk_training.NetWorking.data.VkResponse
import kotlinx.coroutines.Deferred
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Callback
import retrofit2.http.HTTP

private const val VK_METHOD: String = "users.get"
private const val VK_V: String = "5.89"
private const val PARAM_USER_ID = "user_ids"
private const val ACCESS_TOKEN = "05f4702b05f4702b05f4702be9058688e7005f405f4702b5af329a100239dcfd975678b"


/* The link
https://api.vk.com/method/users.get?user_ids=123456&access_token=05f4702b05f4702b05f4702be9058688e7005f405f4702b5af329a100239dcfd975678b&v=5.89
 */

interface IJsonVKApi {
    @GET(VK_METHOD)
    fun  getUserInfo(

        @Query(PARAM_USER_ID)user_id:String
        //not good
//        @Query("access_token") access_token:String = ACCESS_TOKEN,
//        @Query("v")vk_v:String = VK_V
    ): Call<VkResponse>

    companion object{
        val instance: IJsonVKApi by lazy {
            val requestInterceptor = Interceptor {
                    chain -> val url  = chain.request()
                .url()
                .newBuilder()
                .addQueryParameter("access_token", ACCESS_TOKEN)
                .addQueryParameter("v", VK_V)
                .build()
                val request  = chain.request()
                    .newBuilder()
                    .url(url)
                    .build()
                return@Interceptor chain.proceed(request)
            }
            val okHttpClient1:OkHttpClient = OkHttpClient.Builder()
                .addInterceptor(requestInterceptor)
                .build()
            NetworkService.getRetrofit(okHttpClient1).create<IJsonVKApi>(IJsonVKApi::class.java)
        }

    }
}