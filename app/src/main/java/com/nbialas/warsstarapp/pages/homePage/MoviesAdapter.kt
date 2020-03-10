package com.nbialas.warsstarapp.pages.homePage

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nbialas.warsstarapp.R
import com.nbialas.warsstarapp.models.movie.SingleMovie
import kotlinx.android.synthetic.main.item_movie.view.*

class MoviesAdapter : RecyclerView.Adapter<MovieHolder>() {

    private var data: List<SingleMovie>? = null
    var onClickAction: (movie: SingleMovie) -> Unit = {}

    fun setData(items: List<SingleMovie>?) {
        this.data = items
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return MovieHolder(view)
    }

    override fun getItemCount(): Int {
        return data?.size ?: 0
    }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        val movie = data?.get(position)
        movie?.let {
            holder.itemView.movieTitle.text = it.title
            holder.itemView.setOnClickListener {
                onClickAction(movie)
            }
        }

    }
}


class MovieHolder(v: View) : RecyclerView.ViewHolder(v)