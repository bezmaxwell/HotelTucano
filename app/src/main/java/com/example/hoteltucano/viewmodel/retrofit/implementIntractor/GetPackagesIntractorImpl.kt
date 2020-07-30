package com.example.hoteltucano.viewmodel.retrofit.implementIntractor

import com.example.hoteltucano.model.EntityPackages
import com.example.hoteltucano.viewmodel.retrofit.NetworkUtils
import com.example.hoteltucano.viewmodel.retrofit.interfaceRetrofit.PackagesEndpoint
import com.example.hoteltucano.viewmodel.retrofit.interfaceRetrofit.MainContract
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GetPackagesIntractorImpl:
    MainContract.PackagesContract.GetPackagesIntractor  {

    override fun getPackagesArrayList(onFinishedListener: MainContract.PackagesContract.GetPackagesIntractor.OnFinishedListener) {

        val service: PackagesEndpoint = NetworkUtils.getRetrofitInstance()
            .create(PackagesEndpoint::class.java)

        val call:Call<List<EntityPackages>> = service.getPackagesHotelTucano()

        call.enqueue(object :Callback<List<EntityPackages>> {

            override fun onResponse(call: Call<List<EntityPackages>>, response: Response<List<EntityPackages>>) {
                    onFinishedListener.onFinished(response.body() as ArrayList<EntityPackages>)
            }

            override fun onFailure(call: Call<List<EntityPackages>>, t: Throwable) {
                    onFinishedListener.onFailure(t)
            }
        })

    }
}