package com.nbialas.warsstarapp.tools

import android.view.View

object Tools {
//    fun getMovieId(movie: String): String {
//        val correctUrl = movie.replace("films/", "?films=")
//        val uri = Uri.parse(correctUrl)
//        val id = uri.getQueryParameter("films")
//        return id!!
//    }


    fun setVisibility(show: Boolean): Int {
        return if (show) {
            View.VISIBLE
        } else {
            View.GONE
        }
    }
}