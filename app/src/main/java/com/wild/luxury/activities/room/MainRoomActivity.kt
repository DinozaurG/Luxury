package com.wild.luxury.activities.room

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.wild.luxury.R
import com.wild.luxury.network.Room
import com.wild.luxury.activities.catalog.CatalogActivity
import com.wild.luxury.presenter.MainRoomPresenter
import com.wild.luxury.presenter.MainRoomView
import kotlinx.android.synthetic.main.activity_main_room.*
import kotlinx.android.synthetic.main.activity_main_room_item_header.*

class MainRoomActivity : AppCompatActivity(), MainRoomView {

    private val presenter = MainRoomPresenter()
    private val adapter = RoomAdapter()
    private lateinit var builder: AlertDialog.Builder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_room)

        builder = AlertDialog.Builder(this)
        builder.setView(R.layout.progress_dialog)
        builder.setCancelable(false)

        presenter.bindView(this)
        room_recycler.adapter = adapter
        room_recycler.layoutManager = LinearLayoutManager(this)

        fab.setOnClickListener {
            presenter.onFabClicked()
        }
    }

    override fun onResume() {
        super.onResume()

        presenter.updateRoomItems(intent.getIntExtra("roomType", 2), builder)
    }
    override fun changeActivity() {
        val intent = Intent(this, CatalogActivity::class.java)
//            .apply { roomType?.let { putExtra("roomType", roomType) } }
        startActivity(intent)
    }

    override fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun showRoom(room: Room) {
        adapter.list = room.products
        adapter.name = room.name
        adapter.roomType = room.roomType
        adapter.productCount = room.productCount.toString()
        adapter.maxProduct = room.maxProducts.toString()
        adapter.roomArea = room.area.toString()
    }

    override fun changeVisibility() {
        fab.visibility = View.VISIBLE
        layout.visibility = View.VISIBLE
    }
}
