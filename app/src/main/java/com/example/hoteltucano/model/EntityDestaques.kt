package com.example.hoteltucano.model


import com.google.gson.annotations.SerializedName

data class DataDestaques (

    @SerializedName("id") var Id:String,
    @SerializedName("Title") var Title: String,
    @SerializedName("Description")var Description: String,
    @SerializedName("stars")var stars: Int,
    @SerializedName("Imagem")var Imagem: String,
    @SerializedName("OldPrice")var OldPrice:Int,
    @SerializedName("CurrentPrice")var CurrentPrice:Int,
    @SerializedName("NumDeDias")var NumDeDias:Int,
    @SerializedName("NumPessoas")var NumPessoas: Int,
    @SerializedName("Desconto")var Desconto: String)




