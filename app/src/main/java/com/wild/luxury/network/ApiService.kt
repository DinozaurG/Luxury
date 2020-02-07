package com.wild.luxury.network

import com.wild.luxury.CatalogList
import com.wild.luxury.Product
import com.wild.luxury.Room
import retrofit2.Call
import retrofit2.http.*


interface ApiService {
    @GET("catalog")
    fun getProducts(): Call<CatalogList>

    @GET("rooms/{id}")
    fun getRooms(@Path("id") id: Int): Call<Room>

}