package com.wild.luxury.presenter

class MainRoomPresenter {

    private lateinit var view: MainRoomView

    fun bindView(view: MainRoomView) {
        this.view = view
    }

    fun onFabClicked() {
        view.changeActivity()
    }
}