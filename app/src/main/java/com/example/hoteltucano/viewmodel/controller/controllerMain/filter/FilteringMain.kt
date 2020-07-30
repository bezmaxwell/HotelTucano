package com.example.hoteltucano.viewmodel.controller.controllerMain.filter

import android.widget.Filter
import android.widget.Filterable
import com.example.hoteltucano.model.DataDestaques
import java.util.*
import kotlin.collections.ArrayList


// reposicionar elemento em subdivisoes úteis viewHolder

class FilteringMain(private var hotelTucano: List<DataDestaques>):Filterable {

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
              //  notifyDataSetChanged()
            }
        }
    }


}