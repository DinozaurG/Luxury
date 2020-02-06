package com.wild.luxury

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Room(
    val name: String,
    @SerializedName("products") val productList: List<Product>
)
data class Product (
    val name: String,
    val price: Int,
    var count: Int,
    val description: String,
    @SerializedName("photo_url") val photoUrl:String
) : Serializable

data class CatalogList (
    val products: List<Product>
)