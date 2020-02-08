package com.wild.luxury.activities.roomtype


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import androidx.fragment.app.Fragment
import com.wild.luxury.R
import com.wild.luxury.activities.room.MainRoomActivity
import com.wild.luxury.presenter.RoomTypePresenter
import com.wild.luxury.presenter.RoomTypeView
import kotlinx.android.synthetic.main.fragment_tab_fragment2.*


/**
 * A simple [Fragment] subclass.
 */
class TabFragment2 : Fragment(), RoomTypeView{

    private val presenter = RoomTypePresenter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tab_fragment2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val buttonClick = AlphaAnimation(1f, 0.2f)

        presenter.bindView(this)

        buttonChooseRoomType2.setOnClickListener {
            it.startAnimation(buttonClick)
            presenter.onButtonClick()
        }
    }

    override fun changeActivity() {
        val intent = Intent(activity, MainRoomActivity::class.java).apply {
            putExtra("roomType", 2)
        }
        startActivity(intent)
    }

}
