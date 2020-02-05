package com.wild.luxury.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_room)

        presenter.bindView(this)

        supportActionBar?.title = "${intent.getStringExtra("roomType")} room"

        val adapter = RoomAdapter()
       /* adapter.list = listOf(
            Product("Table", 100),
            Product("Table", 200),
            Product("Table", 100),
            Product("Table", 100),
            Product("Table", 100),
            Product("Table", 100),
            Product("Table", 100)
        )*/
        room_recycler.adapter = adapter
        room_recycler.layoutManager = LinearLayoutManager(this)

        fab.setOnClickListener {
            presenter.onFabClicked()
        }
    }

    override fun changeActivity() {
        val intent = Intent(this, Catalog::class.java)
//            .apply { putExtra("roomType", "Modest") }
        startActivity(intent)
    }
}
