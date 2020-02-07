package com.wild.luxury.presenter

import android.app.AlertDialog
import android.util.Log
import android.widget.Toast
import com.wild.luxury.network.Room
import com.wild.luxury.App
import com.wild.luxury.network.BuyProduct
import com.wild.luxury.network.Product
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainRoomPresenter {

    private lateinit var view: MainRoomView
    /*
    Возня с диалогами для того, что бы при удалении продукта, диалог не показывался два раза
     */
    var dialog: AlertDialog? = null

    fun bindView(view: MainRoomView) {
        this.view = view
    }

    fun updateRoomItems(roomId: Int, builder: AlertDialog.Builder) {

        if (dialog == null) {
            dialog = builder.create()
            dialog!!.show()
        }

        App.usersService.getRooms(roomId).enqueue(object : Callback<Room>{
            override fun onFailure(call: Call<Room>, t: Throwable) {
                view.showToast("$t")
                Log.d("responceErr", "$t")
                dialog!!.dismiss()
            }

            override fun onResponse(call: Call<Room>, response: Response<Room>) {
                response.body()?.let {
                    view.showRoom(it)
                    view.changeVisibility()
                }
                dialog!!.dismiss()
            }

        })
    }

    fun onFabClicked() {
        view.changeActivity()
    }

    fun onDelButtonClicked(delProduct: BuyProduct, builder: AlertDialog.Builder) {

        dialog = builder.create()
        dialog!!.show()

        App.usersService.deleteProduct(delProduct).enqueue(object : Callback<Product>{
            override fun onFailure(call: Call<Product>, t: Throwable) {
                Log.d("reposnceErr", "${t.message}")
                view.showToast("Ошибка: ${t.message}")
                dialog!!.dismiss()
            }

            override fun onResponse(call: Call<Product>, response: Response<Product>) {
                view.updateList()
            }

        })
    }
}