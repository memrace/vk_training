package com.android.example.vk_training.NetWorking

import android.net.Uri
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL
import java.util.*

// CONSTs

private const val VK_URL: String = "https://api.vk.com"
private const val VK_METHOD: String = "/method/users.get"
private const val VK_V: String = "5.89"
private const val PARAM_VERSION = "v"
private const val PARAM_USER_ID = "user_ids"


class NetWork {


    fun generateURL(id:String):URL {
        val builtURL: Uri = Uri.parse(VK_URL + VK_METHOD)
            .buildUpon()
            .appendQueryParameter(PARAM_USER_ID,id)
            .appendQueryParameter(PARAM_VERSION,VK_V)
            .build()

        return URL(builtURL.toString())
    }

    fun getResponseFromURL(url:URL):String? {
        val urlConnection: HttpURLConnection = url.openConnection() as HttpURLConnection
         try {
             val inputStream:InputStream = urlConnection.inputStream
             val scanner = Scanner(inputStream)
             scanner.useDelimiter("\\A")

             return if (scanner.hasNext())
                 scanner.next()
             else null
         } finally {
             urlConnection.disconnect()
         }


    }
}