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

        val product = intent.getSerializableExtra("product") as Product?

        val adapter = RoomAdapter()
        if(product!=null) {
            adapter.list = listOf(
                product
            )

        }
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
