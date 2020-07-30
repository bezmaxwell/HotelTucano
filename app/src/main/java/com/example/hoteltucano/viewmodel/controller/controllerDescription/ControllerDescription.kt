package com.example.hoteltucano.viewmodel.controller.controllerDescription

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.example.hoteltucano.R
import com.example.hoteltucano.model.DataDescription
import com.example.hoteltucano.view.uiSec.Buy_Ticket
import com.example.hoteltucano.view.uiSec.DescriptionHotel
import com.example.hoteltucano.viewmodel.controller.controllerDescription.adapter.AdapterDescriptionViewPager
import com.example.hoteltucano.viewmodel.controller.controllerDescription.adapter.ExpandableAdapter
import com.example.hoteltucano.viewmodel.controller.controllerMain.HotelTucanoHolder
import com.example.hoteltucano.viewmodel.viewmodel.DescriptionViewModel
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.description_bottom.view.*
import kotlinx.android.synthetic.main.description_map.view.*
import kotlinx.android.synthetic.main.description_middle.view.*
import kotlinx.android.synthetic.main.description_top.view.*
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.Main

private const val ITEM_VIEW_MAIN = 1
private const val ITEM_VIEW_MIDDLE = 2
private const val ITEM_VIEW_MAP = 3
private const val ITEM_VIEW_END = 4

private lateinit var mAdapterViewPager: AdapterDescriptionViewPager
private lateinit var mMap:GoogleMap

class ControllerDescription(private val secundaryHotel: List<DataDescription>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun getItemViewType(position: Int): Int {
        return if (secundaryHotel[position].layout_pos == 1) {
            ITEM_VIEW_MAIN
        } else if (secundaryHotel[position].layout_pos == 2) {
            ITEM_VIEW_MIDDLE
        } else if (secundaryHotel[position].layout_pos == 3) {
            ITEM_VIEW_MAP
        } else {
            ITEM_VIEW_END
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        if (viewType == ITEM_VIEW_MAIN) {
            val views = (LayoutInflater.from(parent.context)
                .inflate(R.layout.description_top, parent, false))
            return DataViewMain(views)
        } else if (viewType == ITEM_VIEW_MIDDLE) {
            val views = (LayoutInflater.from(parent.context)
                .inflate(R.layout.description_middle, parent, false))
            return DataViewMiddle(views)
        } else if (viewType == ITEM_VIEW_MAP) {
            val view = (LayoutInflater.from(parent.context)
                .inflate(R.layout.description_map, parent, false))
            return DataViewMap(view)
        } else {
            val views = (LayoutInflater.from(parent.context)
                .inflate(R.layout.description_bottom, parent, false))
            return DataViewEnd(views)
        }
    }

    override fun getItemCount(): Int = secundaryHotel.size

    class DataViewMain(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(list: DataDescription) {

            itemView.title_top.setText(list.title_top)
            itemView.days_entry_top.setText(list.days_entry_top)
            itemView.days_out_top.setText(list.days_out_top)
            itemView.description_top.text = list.description_top
            itemView.num_diarias_top.text = list.num_diarias_top.toString()
            itemView.oldPrice_top.text = list.oldPrice_top.toString()
            itemView.current_price_top.text = list.current_price_top.toString()
            itemView.porcent_top.text = list.porcent_top

            val images_top: ArrayList<String> = list.images_top
            mAdapterViewPager = AdapterDescriptionViewPager(itemView.context, images_top)

                val mViewPager = itemView.findViewById<ViewPager>(R.id.images_top)
                mViewPager.adapter = mAdapterViewPager
            }
    }


    class DataViewMiddle(itemView: View) :RecyclerView.ViewHolder(itemView) {

         fun bind(list: DataDescription) {

            itemView.title_middle.setText(list.title_middle)
            itemView.sub_description_middle.setText(list.sub_description_middle)
            itemView.num_diarias_middle.setText(list.num_diarias_middle.toString())
            itemView.num_person_middle.setText(list.num_person_middle.toString())
            itemView.old_price_middle.setText(list.old_price_middle.toString())
            itemView.porcent_middle.setText(list.porcent_middle)
            itemView.current_price_middle.setText(list.current_price_middle.toString())

            // titleHotel = (itemView.context as AppCompatActivity).intent.getStringExtra()
            itemView.button_buy_middle.setOnClickListener {
                val intent1  = ( itemView.context as AppCompatActivity).intent.getStringExtra(
                    HotelTucanoHolder.TITLE)

                val intent = Intent(itemView.context, Buy_Ticket::class.java)
                val title = intent1
                intent.putExtra(DescriptionHotel.NAME,title)
                ContextCompat.startActivity(itemView.context, intent, Bundle.EMPTY)

            }
        }
    }

    class DataViewMap(itemView: View) : RecyclerView.ViewHolder(itemView), OnMapReadyCallback {

        private var mLatitude: Double = 0.0
        private var mLogintude: Double = 0.0

        fun bind(list: DataDescription) {

                itemView.address_map.setText(list.address_middle)
                mLatitude = list.map_view_latitude
                mLogintude = list.map_view_logintude

                val map = (itemView.context as AppCompatActivity).supportFragmentManager.findFragmentById(R.id.map_view) as SupportMapFragment
                map.getMapAsync(this@DataViewMap)

        }

        override fun onMapReady(googleMap: GoogleMap?) {
                mMap = googleMap!!
                val latlog = LatLng(mLatitude, mLogintude)
                mMap.addMarker(MarkerOptions().position(latlog).title("Location"))
                mMap.moveCamera(CameraUpdateFactory.newLatLng(latlog))
            }
}

    class DataViewEnd(itemView: View) : RecyclerView.ViewHolder(itemView) {

      fun bind(list: DataDescription) {
           val header =  list.header
           val  body =  list.body
                itemView.expandableListView.setAdapter(ExpandableAdapter(itemView.context, header, body))

            }
        }

    override  fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (getItemViewType(position) == ITEM_VIEW_MAIN) {
            (holder as DataViewMain).bind(secundaryHotel[position])
        } else if (getItemViewType(position) == ITEM_VIEW_MIDDLE) {
            (holder as DataViewMiddle).bind(secundaryHotel[position])
        } else if(getItemViewType(position) == ITEM_VIEW_MAP) {
            (holder as DataViewMap).bind(secundaryHotel[position])
        }else {
            (holder as DataViewEnd).bind(secundaryHotel[position])
        }
    }
}


