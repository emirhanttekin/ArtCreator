package com.emirhantekin.aicreatordemo.service

import android.hardware.display.VirtualDisplay
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.URL

class APIClient {

    object Text2ImageClient {
        private const val BASE_URL = "https://dezgo.p.rapidapi.com"
        private val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service: Text2ImageService = retrofit.create(Text2ImageService::class.java)
    }

}