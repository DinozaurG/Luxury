package com.wild.luxury.activities.room

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.wild.luxury.R
import kotlinx.android.synthetic.main.activity_main_room_item_header.view.*

const val LUXURY = "Luxury"
const val STANDART = "Standart"
const val ECONOM = "Econom"

class HeaderViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    fun bind(
        roomName: String,
        roomType: String,
        roomArea: String,
        roomMaxProducts: String,
        roomProductCount: String,
        listSize: Int
    ) {
        itemView.room_number_name.text = "Номер комнаты: $roomName"
        itemView.room_area.text = "Площадь: $roomArea"
        itemView.room_product_count.text = "Мебели сейчас: $roomProductCount"
        itemView.room_max_product.text = "Макс. мебели: $roomMaxProducts"

        when (roomType) {
            "Super ultra luxary" -> {
                itemView.room_type.text = "Тип: $LUXURY"
                itemView.roomImage.setImageResource(R.drawable.luxury_hotel_room)
            }
            "Ultra standard" -> {
                itemView.room_type.text = "Тип: $STANDART"
                itemView.roomImage.setImageResource(R.drawable.standart_hotel_room)
            }
            "Econom" -> {
                itemView.room_type.text = "Тип: $ECONOM"
                itemView.roomImage.setImageResource(R.drawable.econom_hotel_room)
            }
            else -> Unit
        }

        if (listSize != 0) {
            itemView.text_missed.visibility = View.GONE
        } else {
            itemView.text_missed.visibility = View.VISIBLE
        }
    }
}
