package com.wild.luxury.presenter

import android.app.AlertDialog
import android.util.Log
import android.widget.Toast
import com.wild.luxury.Room
import com.wild.luxury.network.App
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainRoomPresenter {

    private lateinit var view: MainRoomView

    fun bindView(view: MainRoomView) {
        this.view = view
    }

    fun updateRoomItems(roomId: Int, builder: AlertDialog.Builder) {
        val dialog = builder.create()
        dialog.show()

        App.usersService.getRooms(roomId).enqueue(object : Callback<Room>{
            override fun onFailure(call: Call<Room>, t: Throwable) {
                view.showToast("$t")
                Log.d("responceErr", "$t")
                dialog.dismiss()
            }

            override fun onResponse(call: Call<Room>, response: Response<Room>) {
                response.body()?.let {
                    view.showRoom(it)
                    view.changeFabVisibility()
                }
                dialog.dismiss()
            }

        })
    }

    fun onFabClicked() {
        view.changeActivity()
    }
}