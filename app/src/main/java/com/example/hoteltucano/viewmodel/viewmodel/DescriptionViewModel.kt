package com.example.hoteltucano.viewmodel.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.hoteltucano.model.DataDescription

class DescriptionViewModel:ViewModel() {

     val modelCycleTop: MutableLiveData<List<DataDescription>> by lazy {
         MutableLiveData<List<DataDescription>>()
     }

}