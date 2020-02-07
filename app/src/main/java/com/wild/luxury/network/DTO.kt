package com.wild.luxury.network

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Room(
    @SerializedName("id") val id:Int,
    val name: String,
    val area: Int,
    @SerializedName("max_product")val maxProducts: Int,
    @SerializedName("product_count")val productCount: Int,
    @SerializedName("room_type")val roomType: String,
    val products: List<Product>
)
data class CatalogList (
    val products: List<Product>
)
data class Product (
    val id: Int,
    val category: String,
    @SerializedName("category_id")val categotyId: Int,
    val name: String,
    val price: Int,
    var count: Int,
    val description: String,
    @SerializedName("photo_url") val photoUrl:String
) : Serializable

data class BuyProduct(
    @SerializedName("user_id") val userID:Int,
    @SerializedName("product_id") var productID:Int,
    @SerializedName("room_id") val roomID:Int

)

