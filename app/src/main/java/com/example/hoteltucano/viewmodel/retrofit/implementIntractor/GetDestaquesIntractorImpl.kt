package com.example.hoteltucano.viewmodel.retrofit.implementIntractor

import com.example.hoteltucano.model.DataDestaques
import com.example.hoteltucano.viewmodel.retrofit.interfaceRetrofit.Endpoint
import com.example.hoteltucano.viewmodel.retrofit.NetworkUtils
import com.example.hoteltucano.viewmodel.retrofit.interfaceRetrofit.MainContract
import retrofit2.Callback
import retrofit2.Response

class GetDestaquesIntractorImpl: MainContract.GetDestaquesIntractor {

   override  fun getDestaquesArrayList(onFinishedListener: MainContract.GetDestaquesIntractor.OnFinishedListener) {

        val service: Endpoint = NetworkUtils.getRetrofitInstance()
            .create(Endpoint::class.java)

        /** Call the method with parameter in the interface to get the notice data*/
          val call:retrofit2.Call<List<DataDestaques>> = service.getHotelTuc()

        call.enqueue(object :Callback<List<DataDestaques>> {

            override fun onResponse(call: retrofit2.Call<List<DataDestaques>>, response: Response<List<DataDestaques>>) {
                   onFinishedListener.onFinished(response.body() as ArrayList<DataDestaques>)

            }

            override fun onFailure(call: retrofit2.Call<List<DataDestaques>>, t: Throwable) {
                    onFinishedListener.onFailure(t)
            }
        })

    }




}