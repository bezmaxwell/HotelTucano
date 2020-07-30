package com.example.hoteltucano.viewmodel.controller.controllerMain.adapter

import android.R
import android.view.LayoutInflater
import android.widget.ArrayAdapter
import com.example.hoteltucano.databinding.FragmentHotelBinding
import com.example.hoteltucano.model.SpinnerDataClass


class SpinnerHoteisAdapter {

        private lateinit var mSpinnerDataClass:SpinnerDataClass.spinnerData
        private lateinit var mBinding: FragmentHotelBinding

fun adapterTest(layoutInflater: LayoutInflater):LayoutInflater {

        mSpinnerDataClass = SpinnerDataClass.spinnerData

        mBinding = FragmentHotelBinding.inflate(layoutInflater)


       val adapterRoom: ArrayAdapter<String> = ArrayAdapter(mBinding.root.context, R.layout.simple_spinner_dropdown_item, mSpinnerDataClass.room)
        adapterRoom.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
        mBinding.spinnerRoomHotel.adapter = adapterRoom


        // organizando spinner de Adultos para classe Hotel
        val adapterAdultos: ArrayAdapter<String> = ArrayAdapter(mBinding.root.context, R.layout.simple_spinner_dropdown_item, mSpinnerDataClass.adultos)
        adapterAdultos.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
        mBinding.spinnerPeopleHotel.adapter = adapterAdultos

        // setando adapter de crianças

        val adapterChildren: ArrayAdapter<String> = ArrayAdapter(mBinding.root.context, R.layout.simple_spinner_dropdown_item,mSpinnerDataClass.childrens)
        adapterChildren.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
        mBinding.spinnerChildrenHotel.adapter = adapterChildren

        return layoutInflater
        }
}