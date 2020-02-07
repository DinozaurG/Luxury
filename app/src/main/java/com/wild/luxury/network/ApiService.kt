package com.wild.luxury.network

import retrofit2.Call
import retrofit2.http.*


interface ApiService {
    @GET("catalog")
    fun getProducts(): Call<CatalogList>

    @GET("rooms/{id}")
    fun getRooms(@Path("id") id: Int): Call<Room>

    @POST("products/buy")
    fun postProduct(
        @Body buyProduct: BuyProduct
    ):Call<Product>

    @POST("/products/delete")
    fun deleteProduct(
        @Body buyProduct: BuyProduct
    ):Call<Product>
}