package com.example.hoteltucano.viewmodel.retrofit.interfaceRetrofit

import com.example.hoteltucano.model.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url


interface Endpoint {
    @GET("/hotelTuc")
  fun getHotelTuc(): Call<List<DataDestaques>>

}
interface SecondaryEndpoint {
    @GET
    fun getSecondaryHotelTucano(@Url idHotel:String):Call<List<DataDescription>>
}

interface PackagesEndpoint {
    @GET("/packages")
    fun getPackagesHotelTucano():Call<List<EntityPackages>>
}



