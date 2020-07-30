package com.example.hoteltucano.view.uiMain.ui.packages

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hoteltucano.viewmodel.controller.controllerMain.ControllerPackages
import com.example.hoteltucano.databinding.FragmentPackageBinding
import com.example.hoteltucano.model.EntityPackages
import com.example.hoteltucano.viewmodel.PaddingSpace
import com.example.hoteltucano.viewmodel.retrofit.implementIntractor.GetPackagesIntractorImpl
import com.example.hoteltucano.viewmodel.retrofit.implementPresenter.PackagesPresenterImpl
import com.example.hoteltucano.viewmodel.retrofit.interfaceRetrofit.MainContract

class PackagesFragment : Fragment(),
    MainContract.PackagesContract.PackagesView {

    private lateinit var mControllerPackagesHotelTucano: ControllerPackages
    private lateinit var binding:FragmentPackageBinding
    private lateinit var presenter: MainContract.PackagesContract.presenter

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = FragmentPackageBinding.inflate(layoutInflater,container,false)

        presenter =
            PackagesPresenterImpl(
                this,
                GetPackagesIntractorImpl()
            )
        presenter.requestDataFromServer()
        initializeRecyclerView()

        binding.root.setPadding(0,0,0,100)

        return binding.root
    }

    private fun initializeRecyclerView() {

        binding.recyclerViewPackage.apply {

            val layoutManager: RecyclerView.LayoutManager = GridLayoutManager(activity, 2)
            binding.recyclerViewPackage.setLayoutManager(layoutManager)
            binding.recyclerViewPackage.addItemDecoration(
                PaddingSpace(
                    20,
                    100,
                    20,
                    20
                )
            )
            setHasFixedSize(true)
        }
    }

    override fun showProgress() { binding.progressRecyclerPackages.visibility = View.VISIBLE }

    override fun hideProgress() { binding.progressRecyclerPackages.visibility = View.INVISIBLE }


    override fun setDataToRecyclerView(packagesArrayList: ArrayList<EntityPackages>) {

        mControllerPackagesHotelTucano = ControllerPackages(packagesArrayList)
        binding.recyclerViewPackage.adapter = mControllerPackagesHotelTucano

    }

    override fun onResponseFailure(exception: Throwable) = Toast.makeText(context,"Something gone wrong...Error message:" + exception.message, Toast.LENGTH_SHORT).show()


    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }
}