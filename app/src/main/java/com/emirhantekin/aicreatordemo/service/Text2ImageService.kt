package com.emirhantekin.aicreatordemo.service

import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.*


interface Text2ImageService {
        @FormUrlEncoded
        @POST("/text2image")
        suspend fun generateImage(
            @Field("prompt") prompt: String,
            @Field("guidance") guidance: Double,
            @Field("width") width: Int,
            @Field("height") height: Int,
            @Field("sampler") sampler: String,
            @Field("steps") steps: Int,
            @Header("X-RapidAPI-Key") apiKey: String
        ): Response<ResponseBody>
    }
