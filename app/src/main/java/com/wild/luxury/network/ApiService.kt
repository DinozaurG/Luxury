package com.wild.luxury.network

import com.wild.luxury.Product
import com.wild.luxury.Room
import retrofit2.Call
import retrofit2.http.*


interface ApiService {
    @GET("products")
    fun getProducts(): Call<List<Product>>

    @GET("rooms")
    fun gerRooms(): Call<List<Room>>

}