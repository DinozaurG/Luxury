package com.wild.luxury.activities

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.wild.luxury.Product
import com.wild.luxury.R
import com.wild.luxury.Room
import com.wild.luxury.adapters.RoomAdapter
import com.wild.luxury.presenter.MainRoomPresenter
import com.wild.luxury.presenter.MainRoomView
import kotlinx.android.synthetic.main.activity_main_room.*

class MainRoomActivity : AppCompatActivity(), MainRoomView {

    private val presenter = MainRoomPresenter()
    private val adapter = RoomAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_room)

        presenter.bindView(this)

        room_recycler.adapter = adapter
        room_recycler.layoutManager = LinearLayoutManager(this)

        fab.setOnClickListener {
            presenter.onFabClicked()
        }
    }

    override fun onResume() {
        super.onResume()
        val builder = AlertDialog.Builder(this)
        builder.setView(R.layout.progress_dialog)
        builder.setCancelable(false)
        presenter.updateRoomItems(intent.getIntExtra("roomType", 2), builder)
    }

    override fun changeActivity() {
        val intent = Intent(this, Catalog::class.java)
//            .apply { roomType?.let { putExtra("roomType", roomType) } }
        startActivity(intent)
    }

    override fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun showRoom(room: Room) {
        adapter.list = room.productList
        adapter.name = room.name
        adapter.roomType = room.roomType
        adapter.productCount = room.productCount.toString()
        adapter.maxProduct = room.maxProducts.toString()
        adapter.roomArea = room.area.toString()
    }

    override fun changeFabVisibility() {
        fab.visibility = View.VISIBLE
    }
}
