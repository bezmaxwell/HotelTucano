package com.example.hoteltucano.viewmodel.retrofit.implementPresenter

import com.example.hoteltucano.model.DataDestaques
import com.example.hoteltucano.viewmodel.retrofit.interfaceRetrofit.MainContract

class MainPresenterImpl : MainContract.presenter, MainContract.GetDestaquesIntractor.OnFinishedListener {

    private var mainView: MainContract.MainView ?= null
    private var getDestaquesIntractor: MainContract.GetDestaquesIntractor

    constructor(mainView: MainContract.MainView, getDestaquesIntractor: MainContract.GetDestaquesIntractor) {
        this.mainView = mainView
        this.getDestaquesIntractor = getDestaquesIntractor
    }

    override fun onDestroy() {
        mainView = null
    }

    override fun onRefreshButtonCLick()
    {
        if(mainView != null)  mainView?.showProgress() else getDestaquesIntractor.getDestaquesArrayList(this)
    }

    override fun requestDataFromServer() = getDestaquesIntractor.getDestaquesArrayList(this)


    override fun onFinished(destaquesArrayList: ArrayList<DataDestaques>)
    {
        if(mainView != null) {
            mainView?.setDataToRecyclerView(destaquesArrayList)
            mainView?.hideProgress()
        }
    }

    override fun onFailure(t: Throwable)
    {
            if(mainView != null) {
                mainView?.onResponseFailure(t)
                mainView?.hideProgress()
            }
    }
}