package com.example.hoteltucano.viewmodel.retrofit.implementPresenter

import com.example.hoteltucano.model.EntityPackages
import com.example.hoteltucano.viewmodel.retrofit.interfaceRetrofit.MainContract

class PackagesPresenterImpl : MainContract.PackagesContract.presenter,
    MainContract.PackagesContract.GetPackagesIntractor.OnFinishedListener {

    private var packagesView: MainContract.PackagesContract.PackagesView? = null
    private var getPackagesIntractor: MainContract.PackagesContract.GetPackagesIntractor

    constructor(packagesView: MainContract.PackagesContract.PackagesView, getPackagesIntractor: MainContract.PackagesContract.GetPackagesIntractor) {
        this.getPackagesIntractor = getPackagesIntractor
        this.packagesView = packagesView
    }

    override fun onDestroy() {
        packagesView = null
    }

    override fun onRefreshButtonCLick() {
        if (packagesView != null) packagesView?.showProgress() else getPackagesIntractor.getPackagesArrayList(this)
    }

    override fun requestDataFromServer() = getPackagesIntractor.getPackagesArrayList(this)

    override fun onFinished(packagesArrayList: ArrayList<EntityPackages>) {
        if (packagesView != null) {
            packagesView?.setDataToRecyclerView(packagesArrayList)
            packagesView?.hideProgress()
        }
    }

    override fun onFailure(t: Throwable) {
        if (packagesView != null) {
            packagesView?.onResponseFailure(t)
            packagesView?.hideProgress()
        }
    }
}