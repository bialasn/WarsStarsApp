package com.nbialas.warsstarapp.tools

import android.view.View

object Tools {

    fun setVisibility(show: Boolean): Int {
        return if (show) {
            View.VISIBLE
        } else {
            View.GONE
        }
    }
}