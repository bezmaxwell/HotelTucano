package com.example.hoteltucano.viewmodel.retrofit.implementPresenter

import com.example.hoteltucano.model.DataDescription
import com.example.hoteltucano.viewmodel.retrofit.interfaceRetrofit.MainContract

class DescriptionPresenterImpl : MainContract.DescriptionContract.presenter, MainContract.DescriptionContract.GetDescriptionIntractor.onFinishedListener {

    private var mainView: MainContract.DescriptionContract.DescriptionView ?= null
    private var getDescriptionIntractor: MainContract.DescriptionContract.GetDescriptionIntractor

    constructor(mainView: MainContract.DescriptionContract.DescriptionView, getDescriptionIntractor: MainContract.DescriptionContract.GetDescriptionIntractor)
    {
        this.mainView = mainView
        this.getDescriptionIntractor = getDescriptionIntractor
    }

    override fun onDestroy() {
        mainView = null
    }

    override fun onRefreshButtonCLick() {
        if(mainView != null) mainView?.showProgress() else getDescriptionIntractor.getDescriptionArrayList(this)
    }

    override fun requestDataFromServer() = getDescriptionIntractor.getDescriptionArrayList(this)

    override fun onFinished(descriptionArrayList: ArrayList<DataDescription>) {
        if(mainView != null) {
            mainView?.setDataToRecyclerView(descriptionArrayList)
            mainView?.hideProgress()
        }
    }

    override fun onFailure(t: Throwable) {
        if(mainView != null) {
            mainView?.onResponseFailure(t)
            mainView?.hideProgress()
        }
    }


}