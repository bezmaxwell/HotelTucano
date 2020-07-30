package com.example.hoteltucano.viewmodel.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkUtils{
    companion object {
        fun getRetrofitInstance() : Retrofit {
            val path = "https://demo0590047.mockable.io"
            return Retrofit.Builder().baseUrl(path).addConverterFactory(GsonConverterFactory.create()).build()
        }
    }
}