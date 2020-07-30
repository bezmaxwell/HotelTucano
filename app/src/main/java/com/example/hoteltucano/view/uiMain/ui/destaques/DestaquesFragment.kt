package com.example.hoteltucano.view.uiMain.ui.destaques

// app:layout_scrollFlags="scroll|enterAlways"

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hoteltucano.viewmodel.retrofit.interfaceRetrofit.MainContract
import com.example.hoteltucano.viewmodel.retrofit.implementPresenter.MainPresenterImpl
import com.example.hoteltucano.viewmodel.retrofit.interfaceRetrofit.RecyclerItemClickListener
import com.example.hoteltucano.viewmodel.controller.controllerMain.ControllerHotel
import com.example.hoteltucano.viewmodel.retrofit.implementIntractor.GetDestaquesIntractorImpl
import com.example.hoteltucano.databinding.DestaquesNavBarBinding
import com.example.hoteltucano.model.DataDestaques
import com.example.hoteltucano.viewmodel.PaddingSpace


class DestaquesFragment:Fragment(),
    MainContract.MainView{

    private lateinit var mAdapter: ControllerHotel
    private lateinit var presenter: MainContract.presenter
    private lateinit var mBinding:DestaquesNavBarBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

          mBinding = DestaquesNavBarBinding.inflate(layoutInflater, container, false)

        presenter =
            MainPresenterImpl(
                this,
                GetDestaquesIntractorImpl()
            )
        presenter.requestDataFromServer()
        initializeToolbarAndRecyclerView()

        mBinding.root.setPadding(0,0,0,100)

        return mBinding.root
    }

    private fun initializeToolbarAndRecyclerView() {

        (activity as AppCompatActivity).supportActionBar?.hide()

        val recyclerView =  mBinding.recyclerDestaques

        recyclerView.apply {
            val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(activity)
            recyclerView.setLayoutManager(layoutManager)
            recyclerView.addItemDecoration(PaddingSpace(20, 100, 15, 15))
             setHasFixedSize(true)
        }
    }


    override fun showProgress() {
        mBinding.progressRecycle.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        mBinding.progressRecycle.visibility = View.INVISIBLE
    }

    private val recyclerItemListener: RecyclerItemClickListener = object :
        RecyclerItemClickListener {

        override fun onItemClick(destaques: DataDestaques) {

           // Toast.makeText(context,destaques.Title, Toast.LENGTH_SHORT).show()
        }

    }

    override fun setDataToRecyclerView(destaquesArrayList: ArrayList<DataDestaques>) {

        mAdapter = ControllerHotel(destaquesArrayList,recyclerItemListener)
        mBinding.recyclerDestaques.adapter = mAdapter

        handleSearch()
    }

    override fun onResponseFailure(exception: Throwable) = Toast.makeText(context,"Something gone wrong...Error message:" + exception.message,Toast.LENGTH_SHORT).show()

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

    private fun handleSearch() {
        mBinding.searchBarNavBar.setOnQueryTextListener(object :SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                mAdapter.filter.filter(query)
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                mAdapter.filter.filter(newText)
                return false
            }
        })
    }
}

