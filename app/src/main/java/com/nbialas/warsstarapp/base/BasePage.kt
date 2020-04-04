package com.nbialas.warsstarapp.base

import android.view.View
import androidx.fragment.app.Fragment

abstract class BasePage : Fragment() {

    fun setVisibility(show: Boolean): Int {
        return if (show) {
            View.VISIBLE
        } else {
            View.GONE
        }
    }
}