package com.wild.luxury.presenter

import com.wild.luxury.Room

interface MainRoomView {
    fun changeActivity()
    fun showToast(message: String)
    fun showRoom(room: Room)
    fun changeFabVisibility()
}