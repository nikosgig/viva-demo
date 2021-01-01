package com.nikosgig.viva.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "products")
data class ProductModel(
    @PrimaryKey @SerializedName("Id") val id: Int,
    @SerializedName("Name") val name: String,
    @SerializedName("Price") val price: String,
    @SerializedName("Thumbnail") val thumbnail: String,
    @SerializedName("Image") val image: String
)