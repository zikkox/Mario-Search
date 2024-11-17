package com.example.mariosearch.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun createRF(): Retrofit {
    return Retrofit.Builder()
        .baseUrl("https://www.amiiboapi.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}