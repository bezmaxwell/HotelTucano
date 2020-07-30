package com.example.hoteltucano.view.uiMain.ui.more

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.hoteltucano.R


class MoreFragmet:Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val root = inflater.inflate(R.layout.fragment_more, container, false)

        root.setPadding(10,10,10,40)



        return root
    }
}