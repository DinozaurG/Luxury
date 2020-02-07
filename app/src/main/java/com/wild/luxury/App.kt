package com.wild.luxury

import android.app.Application
import com.wild.luxury.network.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class App : Application() {

    companion object {
        private val retrofit =
            Retrofit.Builder()
                .baseUrl("http://172.20.46.85:5005/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        val usersService = retrofit.create(
            ApiService::class.java)
    }
}