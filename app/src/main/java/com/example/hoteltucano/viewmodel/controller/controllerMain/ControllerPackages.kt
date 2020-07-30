package com.example.hoteltucano.viewmodel.controller.controllerMain

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RatingBar
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.hoteltucano.R
import com.example.hoteltucano.model.EntityPackages
import kotlinx.android.synthetic.main.activity_packages.view.*

// passar como paramento a interface
class ControllerPackages(var mControllerPackagesHotelTucano: List<EntityPackages>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val root = IControllerPackagesHotelTucano(LayoutInflater.from(parent.context).inflate(R.layout.activity_packages, parent, false))

        return root
    }

    override fun getItemCount(): Int {
        return mControllerPackagesHotelTucano.size
    }

    //funçao para junçao de data com adapter
    fun addDataControllerPackages(dataPackages: List<EntityPackages>) {
        mControllerPackagesHotelTucano = dataPackages
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            when(holder) {
               is IControllerPackagesHotelTucano -> {
                   holder.bind(mControllerPackagesHotelTucano[position])
               }
            }
    }

    inner class IControllerPackagesHotelTucano(itemview: View) : RecyclerView.ViewHolder(itemview) {
        lateinit var mStar:RatingBar

        fun bind(bind: EntityPackages) {

        mStar = itemView.findViewById(R.id.put_stars_item_packages)
            mStar.rating = bind.stars.toFloat()
            mStar.numStars = 5


                 itemView.price_out_packages.text = (bind.OldPrice).toString()
                 itemView.current_price_packages.text =(bind.CurrentPrice).toString()
                 itemView.description_packages.text =(bind.Description)
                 itemView.title_packages.text = (bind.Title)
                 itemView.num_diarias_packages.text =(bind.NumDeDias).toString()
                 itemView.num_people_packages.text =(bind.NumPessoas).toString()
                 itemView.price_porcent_packages.text = (bind.Desconto)

                Glide.with(itemView.context).load(bind.Imagem).into(itemView.image_packages)

        }

    }
}