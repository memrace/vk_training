package com.android.example.vk_training.NetWorking

import android.net.Uri
import java.io.BufferedInputStream
import java.io.InputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLConnection
import java.util.*


// CONSTs

private const val VK_URL: String = "https://api.vk.com"
private const val VK_METHOD: String = "/method/users.get"
private const val VK_V: String = "5.89"
private const val PARAM_VERSION = "v"
private const val PARAM_USER_ID = "user_ids"
private const val PARAM_ACCESS_TOKEN = "access_token"
private const val ACCESS_TOKEN = "05f4702b05f4702b05f4702be9058688e7005f405f4702b5af329a100239dcfd975678b"


 class NetWork {


    private fun generateURL(id:String):URL {
        val builtURL: Uri = Uri.parse(VK_URL + VK_METHOD)
            .buildUpon()
            .appendQueryParameter(PARAM_USER_ID,id)
            .appendQueryParameter(PARAM_ACCESS_TOKEN, ACCESS_TOKEN)
            .appendQueryParameter(PARAM_VERSION,VK_V)
            .build()

        return URL(builtURL.toString())
    }

      fun getResponseFromURL(id: String):String {
         val newUrlConnection: HttpURLConnection =
             generateURL(id).openConnection() as HttpURLConnection
         var dataS: String = ""
        try {
            val inStream: InputStream = newUrlConnection.inputStream
            val scanner = Scanner(inStream)
            scanner.useDelimiter("/")

            if (scanner.hasNext()) dataS = scanner.nextLine() else dataS = "null"
        } finally {
            newUrlConnection.disconnect()
        }
         return dataS
     }







    }


