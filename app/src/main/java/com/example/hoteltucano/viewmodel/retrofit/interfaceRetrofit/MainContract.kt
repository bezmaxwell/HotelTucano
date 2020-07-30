package com.example.hoteltucano.viewmodel.retrofit.interfaceRetrofit

import com.example.hoteltucano.model.DataDescription
import com.example.hoteltucano.model.DataDestaques
import com.example.hoteltucano.model.EntityPackages

interface MainContract {

    interface presenter {

        fun onDestroy()
        fun onRefreshButtonCLick()
        fun requestDataFromServer()
    }

    interface MainView {
        /** showProgress() and hideProgress() would be used for displaying and hiding the progressBar
         * while the setDataToRecyclerView and onResponseFailure is fetched from the GetNoticeInteractorImpl class**/
        fun showProgress()
        fun hideProgress()
        fun setDataToRecyclerView(destaquesArrayList: ArrayList<DataDestaques>)
        fun onResponseFailure(exception: Throwable)
    }

    /**
     * Intractors are classes built for fetching data from your database, web services, or any other data source.
     **/
    interface GetDestaquesIntractor {

        interface OnFinishedListener {
            fun onFinished(destaquesArrayList: ArrayList<DataDestaques>)
            fun onFailure(t: Throwable)
        }

        fun getDestaquesArrayList(onFinishedListener: OnFinishedListener)
    }


    interface DescriptionContract {

        interface presenter {

            fun onDestroy()
            fun onRefreshButtonCLick()
            fun requestDataFromServer()
        }

        interface DescriptionView {

            fun showProgress()
            fun hideProgress()
            fun setDataToRecyclerView(descriptionArrayList: ArrayList<DataDescription>)
            fun onResponseFailure(exception: Throwable)
            fun saveInstanceRetrofit()
        }



        interface GetDescriptionIntractor {

            interface onFinishedListener {
                fun onFinished(descriptionArrayList: ArrayList<DataDescription>)
                fun onFailure(t: Throwable)
            }

            fun getDescriptionArrayList(onFinishedListener: onFinishedListener)
        }
    }

    interface PackagesContract {

    interface presenter {
        fun onDestroy()
        fun onRefreshButtonCLick()
        fun requestDataFromServer()
    }

    interface PackagesView {
        /** showProgress() and hideProgress() would be used for displaying and hiding the progressBar
         * while the setDataToRecyclerView and onResponseFailure is fetched from the GetNoticeInteractorImpl class**/
        fun showProgress()
        fun hideProgress()
        fun setDataToRecyclerView(packagesArrayList: ArrayList<EntityPackages>)
        fun onResponseFailure(exception: Throwable)
    }

    /**
     * Intractors are classes built for fetching data from your database, web services, or any other data source.
     **/
    interface GetPackagesIntractor {

        interface OnFinishedListener {
            fun onFinished(packagesArrayList: ArrayList<EntityPackages>)
            fun onFailure(t: Throwable)
        }
        fun getPackagesArrayList(onFinishedListener: OnFinishedListener)
        }
    }
}

