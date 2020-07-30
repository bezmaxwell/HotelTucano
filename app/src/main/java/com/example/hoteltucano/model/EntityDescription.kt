package com.example.hoteltucano.model

import com.google.gson.annotations.SerializedName


data class DataDescription (
    @SerializedName( "layout_pos") var layout_pos:Int,
    @SerializedName( "id") var id:String,
    @SerializedName( "images_top") var images_top:ArrayList<String>,
    @SerializedName("title_top") var title_top:String,
    @SerializedName("description_top") var description_top:String,
    @SerializedName("porcent_top") var porcent_top: String,
    @SerializedName("num_diarias_top")var num_diarias_top: Int,
    @SerializedName("days_entry_top")var days_entry_top:String,
    @SerializedName("days_out_top") var days_out_top: String,
    @SerializedName("oldPrice_top") var oldPrice_top: Int,
    @SerializedName("current_price_top") var current_price_top: Int,

    @SerializedName("title_middle")var title_middle: String,
    @SerializedName("sub_description_middle")var sub_description_middle: String,
    @SerializedName("num_diarias_middle")var num_diarias_middle: Int,
    @SerializedName("num_person_middle")var num_person_middle: Int,
    @SerializedName("old_price_middle")var old_price_middle: Int,
    @SerializedName("porcent_middle")var porcent_middle: String,
    @SerializedName("current_price_middle")var current_price_middle: Int,
    @SerializedName("map_view_latitude")var map_view_latitude: Double,
    @SerializedName("map_view_logintude")var map_view_logintude: Double,
    @SerializedName("address_middle")var address_middle: String,
    @SerializedName("body")var body: MutableList<MutableList<String>>,
    @SerializedName("header")var header: MutableList<String>)

