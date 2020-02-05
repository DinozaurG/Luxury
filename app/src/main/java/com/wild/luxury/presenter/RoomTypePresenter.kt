package com.wild.luxury.presenter

class RoomTypePresenter {

    private lateinit var view: RoomTypeView
    fun bindView(view: RoomTypeView) {
        this.view = view
    }

    fun onButtonClick(){
        view.changeActivity()
    }
}