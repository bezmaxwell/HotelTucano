package com.example.hoteltucano.viewmodel.controller.controllerMain

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.RatingBar
import androidx.recyclerview.widget.RecyclerView
import com.example.hoteltucano.R
import com.example.hoteltucano.viewmodel.retrofit.interfaceRetrofit.RecyclerItemClickListener
import com.example.hoteltucano.viewmodel.controller.controllerMain.HotelTucanoHolder.Companion.ID
import com.example.hoteltucano.viewmodel.controller.controllerMain.HotelTucanoHolder.Companion.TITLE
import com.example.hoteltucano.model.DataDestaques
import com.example.hoteltucano.view.uiSec.DescriptionHotel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_destaques.view.*
import java.util.*
import kotlin.collections.ArrayList




class ControllerHotel(private var hotelTucano: List<DataDestaques>,private val recyclerItemListener: RecyclerItemClickListener):RecyclerView.Adapter<HotelTucanoHolder>(),Filterable {

     var listDestaques:List<DataDestaques>

    init {
        this.listDestaques = hotelTucano
    }

    override fun getFilter(): Filter {

        return object :Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charSearch = constraint.toString()

                if (charSearch.isEmpty()) {
                    listDestaques = hotelTucano
                } else {

                    val resultList = ArrayList<DataDestaques>()
                    for (row in hotelTucano) {
                        // se no row.Title conter charsearch retorna resultList adicionando row ao arrayList
                        if (row.Title.toLowerCase(Locale.ROOT).contains(charSearch.toLowerCase(
                                Locale.ROOT))) {
                            resultList.add(row)
                        }
                        //resultado da lista iguala ao array listHotel
                        listDestaques = resultList
                    }

                }
                //checks if we have type text if yes returns te results
                val filterResults = Filter.FilterResults()
                filterResults.values = listDestaques
                return filterResults
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                //get the results psses to countryFilterList
                listDestaques = results?.values as List<DataDestaques>
                 notifyDataSetChanged()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HotelTucanoHolder {
        val HotelTucanoHolderMain = HotelTucanoHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_destaques, parent, false))
        return (HotelTucanoHolderMain)
    }

    override fun getItemCount(): Int = listDestaques.size

    override fun onBindViewHolder(holder: HotelTucanoHolder, position: Int) {

         lateinit var mRatingBar: RatingBar
        val hotel = listDestaques[position]

        holder.itemView.title_item_destaques.text = hotel.Title
        holder.itemView.description_item_destaques.text = hotel.Description
        holder.itemView.price_out_item_destaques.text = hotel.OldPrice.toString()
        holder.itemView.current_price_destaques.text = hotel.CurrentPrice.toString()
        holder.itemView.porcent_item_destaques.text = hotel.Desconto
        holder.itemView.num_diarias_destaques.text = hotel.NumDeDias.toString()
        holder.itemView.num_person_destaques.text = hotel.NumPessoas.toString()

        Picasso.get().load(hotelTucano[position].Imagem).into(holder.itemView.image_item_destaques)

        mRatingBar = holder.itemView.findViewById(R.id.put_stars_item_destaques)
        mRatingBar.rating = hotel.stars.toFloat()
        mRatingBar.numStars = 5

            holder.itemView.setOnClickListener {
                recyclerItemListener.onItemClick(hotelTucano.get(position))
                val intent = Intent(holder.itemView.context, DescriptionHotel::class.java)
                intent.putExtra(ID,hotel.Id)
                intent.putExtra(TITLE,hotel.Title)
                holder.itemView.context.startActivity(intent)
            }
    }

}


class HotelTucanoHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    companion object {
       val ID = "ID"
        val TITLE = "TITLE"
   }
}






