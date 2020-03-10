package com.nbialas.warsstarapp.pages.detailsPage

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nbialas.warsstarapp.R
import com.nbialas.warsstarapp.models.movie.SingleMovie


class CharacterAdapter : RecyclerView.Adapter<CharacterHolder>() {

    private var data: List<SingleMovie>? = null

    fun setData(items: List<SingleMovie>?) {
        this.data = items
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_character, parent, false)
        return CharacterHolder(view)
    }

    override fun getItemCount(): Int {
        return data?.size ?: 0
    }

    override fun onBindViewHolder(holder: CharacterHolder, position: Int) {
        val movie = data?.get(position)
//        movie?.let {
//            holder.itemView.movieTitle.text = it.title
//            holder.itemView.setOnClickListener {
//                onClickAction(movie.url)
//            }
        // }

    }
}


class CharacterHolder(v: View) : RecyclerView.ViewHolder(v)