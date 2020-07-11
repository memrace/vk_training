package com.android.example.vk_training.NetWorking

import com.android.example.vk_training.NetWorking.data.DataVK
import kotlinx.coroutines.Deferred
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.http.GET
import retrofit2.http.Query

// CONSTs
private const val VK_METHOD: String = "users.get"
private const val VK_V: String = "5.89"
private const val PARAM_USER_ID = "user_ids"
private const val ACCESS_TOKEN = "05f4702b05f4702b05f4702be9058688e7005f405f4702b5af329a100239dcfd975678b"


/* The link
https://api.vk.com/method/users.get?user_ids=123456&access_token=05f4702b05f4702b05f4702be9058688e7005f405f4702b5af329a100239dcfd975678b&v=5.89
 */

interface IJsonVKApi {
    @GET(VK_METHOD)
    fun getUserInfo(

        @Query(PARAM_USER_ID)user_id:String
        //not good
//        @Query(PARAM_ACCESS_TOKEN) access_token:String = ACCESS_TOKEN,
//        @Query(PARAM_VERSION)vk_v:String = VK_V
    ): Deferred<DataVK>

    companion object{
        operator fun invoke():IJsonVKApi{
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
            val okHttpClient:OkHttpClient = OkHttpClient.Builder().addInterceptor(requestInterceptor)
                .build()
            return NetworkService.getRetrofit(okHttpClient).create(IJsonVKApi::class.java)
        }
    }
}