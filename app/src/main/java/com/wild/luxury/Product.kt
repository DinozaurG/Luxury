package com.wild.luxury

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Room(
    val name: String,
    val area: Int,
    @SerializedName("max_product")val maxProducts: Int,
    @SerializedName("product_count")val productCount: Int,
    @SerializedName("name_type")val roomType: String,
    @SerializedName("products") val productList: List<Product>
)
data class Product (
    val id: Int,
    val categoty: String,
    @SerializedName("category_id")val categotyId: Int,
    val name: String,
    val price: Int,
    var count: Int,
    val description: String,
    @SerializedName("photo_url") val photoUrl:String
) : Serializable

data class CatalogList (
    val products: List<Product>
)