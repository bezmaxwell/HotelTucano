package com.example.hoteltucano.view.uiSec

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hoteltucano.R
import com.example.hoteltucano.databinding.ActivityDescriptionBinding
import com.example.hoteltucano.viewmodel.controller.controllerDescription.ControllerDescription
import com.example.hoteltucano.viewmodel.controller.controllerMain.HotelTucanoHolder.Companion.ID
import com.example.hoteltucano.model.DataDescription
import com.example.hoteltucano.viewmodel.PaddingSpace
import com.example.hoteltucano.view.uiMain.RegisterActivityScreen
import com.example.hoteltucano.viewmodel.retrofit.implementIntractor.GetDescriptionIntractorImpl
import com.example.hoteltucano.viewmodel.retrofit.implementPresenter.DescriptionPresenterImpl
import com.example.hoteltucano.viewmodel.retrofit.interfaceRetrofit.MainContract
import com.example.hoteltucano.viewmodel.viewmodel.DescriptionViewModel


private lateinit var mAdapter: ControllerDescription
lateinit var idHotel:String
private lateinit var binding:ActivityDescriptionBinding
private lateinit var presenter: MainContract.DescriptionContract.presenter

class DescriptionHotel : AppCompatActivity(), MainContract.DescriptionContract.DescriptionView {

    private val model:DescriptionViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        idHotel =  intent.getStringExtra(ID)!!
        binding = DataBindingUtil.setContentView(this,R.layout.activity_description)

        presenter =
            DescriptionPresenterImpl(
                this,
                GetDescriptionIntractorImpl()
            )
        presenter.requestDataFromServer()
        initializeRecyclerView()

    }

    private fun  initializeRecyclerView() {

        setSupportActionBar(binding.toolbarDescription)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.isHideOnContentScrollEnabled


        val recyclerView = binding.recyclerViewDescription
            recyclerView.apply {
            val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(baseContext)
            recyclerView.setLayoutManager(layoutManager)
            recyclerView.addItemDecoration(PaddingSpace(0, 0, 10, 10))
            recyclerView.setHasFixedSize(true)
        }

    }

    override fun showProgress() {
        binding.progressRecyclerDescription.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        binding.progressRecyclerDescription.visibility = View.INVISIBLE
    }

    override fun setDataToRecyclerView(descriptionArrayList: ArrayList<DataDescription>) {
        mAdapter = ControllerDescription(descriptionArrayList)
            binding.recyclerViewDescription.adapter = mAdapter
    }

    override fun onResponseFailure(exception: Throwable) = Toast.makeText(baseContext,"Something gone wrong...Error message:" + exception.message, Toast.LENGTH_SHORT).show()

    override fun saveInstanceRetrofit() {
        // resolver o que pode ser colocado para instanciar
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.toolbar_class_secundary, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        when (id) {
            R.id.like -> onClickLove()
            R.id.share -> onClickShare()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun onClickShare() {
        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, "Baixe grátis o nosso app: Cadastre-se e divirta-se.")
            type = "text/plain"
        }
        val shareIntent = Intent.createChooser(sendIntent, "Notification")
        startActivity(shareIntent)
    }

    private fun onClickLove() {
        val intent = Intent(baseContext, RegisterActivityScreen::class.java)
        startActivity(intent)
    }

    companion object {
        val NAME = "NAME"
    }
}