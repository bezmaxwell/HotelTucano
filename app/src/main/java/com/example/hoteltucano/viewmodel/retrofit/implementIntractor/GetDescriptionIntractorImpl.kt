package com.example.hoteltucano.viewmodel.retrofit.implementIntractor

import com.example.hoteltucano.model.DataDescription
import com.example.hoteltucano.viewmodel.retrofit.NetworkUtils
import com.example.hoteltucano.viewmodel.retrofit.interfaceRetrofit.SecondaryEndpoint
import com.example.hoteltucano.viewmodel.retrofit.interfaceRetrofit.MainContract
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GetDescriptionIntractorImpl:
    MainContract.DescriptionContract.GetDescriptionIntractor {



    override fun getDescriptionArrayList(onFinishedListener: MainContract.DescriptionContract.GetDescriptionIntractor.onFinishedListener) {

        val path = "https://demo0590047.mockable.io/"
        val service: SecondaryEndpoint = NetworkUtils.getRetrofitInstance()
            .create(SecondaryEndpoint::class.java)
        val call:Call<List<DataDescription>> = service.getSecondaryHotelTucano(path +"hotelTuc/"+ com.example.hoteltucano.view.uiSec.idHotel)

        call.enqueue(object :Callback<List<DataDescription>> {
                override fun onResponse(call: Call<List<DataDescription>>,response: Response<List<DataDescription>>) {
                    onFinishedListener.onFinished(response.body() as ArrayList<DataDescription>)
                }
                override fun onFailure(call: Call<List<DataDescription>>, t: Throwable) {
                    onFinishedListener.onFailure(t)
                }
            })
    }
}