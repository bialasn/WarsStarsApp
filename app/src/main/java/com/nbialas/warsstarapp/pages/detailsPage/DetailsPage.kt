package com.nbialas.warsstarapp.pages.detailsPage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.nbialas.warsstarapp.R
import com.nbialas.warsstarapp.base.BasePage
import com.nbialas.warsstarapp.const.Const.MOVIE_ID
import com.nbialas.warsstarapp.listeners.ProgressBarInterface
import com.nbialas.warsstarapp.models.movie.SingleMovie
import com.nbialas.warsstarapp.stateClass.ResponseCharactersFailed
import com.nbialas.warsstarapp.stateClass.ResponseCharactersSuccess
import kotlinx.android.synthetic.main.page_single_movie.*


class DetailsPage : BasePage() {

    private lateinit var viewModel: DetailsPageViewModel
    private val adapter by lazy { CharacterAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProviders.of(this).get(DetailsPageViewModel::class.java)

        getArgumentsFromFragment()

        return inflater.inflate(R.layout.page_single_movie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setAdapter()
        setListeners()
        ProgressBarInterface.post().showProgressBar(true)
    }

    private fun setListeners() {
        viewModel.singleMovie.observe(viewLifecycleOwner, Observer {
            titleMovie.text = it.title
        })
        viewModel.state.observe(viewLifecycleOwner, Observer {
            ProgressBarInterface.post().showProgressBar(false)
            when (it) {
                is ResponseCharactersSuccess -> {
                    adapter.setData(it.listOfCharacters)
                }
                is ResponseCharactersFailed -> {
                    errorMessageCharacterList.visibility = setVisibility(true)
                }
            }
        })
    }

    private fun setAdapter() {
        characterRecycler.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = this@DetailsPage.adapter
        }
    }

    private fun getArgumentsFromFragment() {
        arguments?.getParcelable<SingleMovie>(MOVIE_ID)?.let {
            viewModel.setSingleMovieValue(it)
        }
    }
}