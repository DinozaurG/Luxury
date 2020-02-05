package com.wild.luxury.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.os.PersistableBundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.wild.luxury.Product
import com.wild.luxury.R
import com.wild.luxury.adapters.RoomAdapter
import com.wild.luxury.presenter.MainRoomPresenter
import com.wild.luxury.presenter.MainRoomView
import kotlinx.android.synthetic.main.activity_main_room.*

class MainRoomActivity : AppCompatActivity(), MainRoomView {

    private val presenter = MainRoomPresenter()
    private var roomType: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_room)

        presenter.bindView(this)

        val product = intent.getSerializableExtra("product") as Product

        val adapter = RoomAdapter()
        adapter.list = listOf(
            product,
            Product("Table", 100, 1, "sd"),
            Product("Table", 200, 2, "sd"),
            Product("Table", 100, 1, "sd"),
            Product("Table", 100, 2, "sd"),
            Product("Table", 100, 1, "sd"),
            Product("Table", 100, 3, "sd"),
            Product("Table", 100, 1, "sd")
        )
        room_recycler.adapter = adapter
        room_recycler.layoutManager = LinearLayoutManager(this)

        fab.setOnClickListener {
            presenter.onFabClicked()
        }
    }

    override fun changeActivity() {
        val intent = Intent(this, Catalog::class.java)
            .apply { roomType?.let { putExtra("roomType", roomType) } }
        startActivity(intent)
    }
}
