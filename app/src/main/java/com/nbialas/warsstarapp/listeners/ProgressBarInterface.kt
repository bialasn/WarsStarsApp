package com.nbialas.warsstarapp.listeners

import com.inverce.mod.v2.events.Event
import com.inverce.mod.v2.events.Listener

interface ProgressBarInterface : Listener {
    fun showProgressBar(show: Boolean)


    companion object {
        fun post() = Event.Bus.post(ProgressBarInterface::class.java)
    }
}