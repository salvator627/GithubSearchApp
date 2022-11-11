package com.example.github.API

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object Retrofit {
    private const val BASE_URL = "https://api.github.com/"

    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val instance = retrofit.create(API::class.java)
}