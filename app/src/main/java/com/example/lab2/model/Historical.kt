package com.example.lab2.model

import com.google.gson.annotations.SerializedName

data class Historical(
    @SerializedName("name") val name: String,
    @SerializedName("title") val title: String,
    @SerializedName("info") val info: information,
//    @SerializedName("born") val born: Int,
//    @SerializedName("died") val died: Int,
//    @SerializedName("info") val info: String,

)

data class information(
    @SerializedName("born") val born: String,
    @SerializedName("died") val died: String,
    @SerializedName("children") val children: Int,

)