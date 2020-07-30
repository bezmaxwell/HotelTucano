package com.example.hoteltucano.viewmodel.controller.controllerDescription.`interface`

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.hoteltucano.model.DataDescription


interface presenter {

    fun DataViewTop()
    fun DataViewMiddle()
    fun DataViewMap()
    fun DataViewBottom()

}





interface DataImpl {

    fun bind(list: DataDescription,view: View)

}


class DataViewMiddleImpl:
    presenter {

    override fun DataViewTop() {

    }

    override fun DataViewMiddle() {

    }

    override fun DataViewMap() {

    }

    override fun DataViewBottom() {

    }


}

class DataViewMiddle(itemView: View) : RecyclerView.ViewHolder(itemView) {



}
