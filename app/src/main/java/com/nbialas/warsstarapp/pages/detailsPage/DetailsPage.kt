package com.nbialas.warsstarapp.pages.detailsPage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.nbialas.warsstarapp.R
import com.nbialas.warsstarapp.const.Const.MOVIE_ID
import com.nbialas.warsstarapp.models.movie.SingleMovie
import kotlinx.android.synthetic.main.page_single_movie.*


class DetailsPage : Fragment() {
    lateinit var viewModel: DetailsPageViewModel
    private val adapter by lazy { CharacterAdapter() }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProviders.of(this).get(DetailsPageViewModel::class.java)
        arguments?.getParcelable<SingleMovie>(MOVIE_ID)?.let {
            viewModel.movieTitle = it.title
            viewModel.charactersList = it.characters
        }
        return inflater.inflate(R.layout.page_single_movie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAdapter()
        titleMovie.text = viewModel.movieTitle
        viewModel.prepareList()
    }

    private fun setAdapter() {
        characterRecycler.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = this@DetailsPage.adapter
        }
    }
}