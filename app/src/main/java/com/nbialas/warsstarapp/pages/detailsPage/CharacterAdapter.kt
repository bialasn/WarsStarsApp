package com.nbialas.warsstarapp.pages.detailsPage

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nbialas.warsstarapp.R
import kotlinx.android.synthetic.main.item_character.view.*


class CharacterAdapter : RecyclerView.Adapter<CharacterHolder>() {

    private var data: List<String>? = null

    fun setData(items: List<String>?) {
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
        holder.itemView.nameOfCharacter.text = movie
    }
}


class CharacterHolder(v: View) : RecyclerView.ViewHolder(v)