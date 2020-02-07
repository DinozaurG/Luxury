package com.wild.luxury.network

import android.annotation.SuppressLint
import android.app.Application
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class App : Application() {

    companion object {
        private val retrofit =
            Retrofit.Builder()
                .baseUrl("http://172.20.46.85:5005/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        val usersService = retrofit.create(ApiService::class.java)
    }

    override fun onCreate() {
        super.onCreate()

    }

}