package com.example.hoteltucano.viewmodel.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.hoteltucano.model.DataDestaques

class DestaquesViewModel(savedStateHandle: SavedStateHandle):ViewModel() {

    val modelCycleDestaques:MutableLiveData<List<DataDestaques>> by lazy {
        MutableLiveData<List<DataDestaques>>()

    }
}