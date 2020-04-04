package com.nbialas.warsstarapp.pages.homePage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.nbialas.warsstarapp.R
import com.nbialas.warsstarapp.base.BasePage
import com.nbialas.warsstarapp.const.Const.MOVIE_ID
import com.nbialas.warsstarapp.listeners.ProgressBarInterface
import com.nbialas.warsstarapp.models.movie.SingleMovie
import com.nbialas.warsstarapp.stateClass.ResponseFailed
import com.nbialas.warsstarapp.stateClass.ResponseSuccess
import kotlinx.android.synthetic.main.page_home.*

class HomePage : BasePage() {

    private lateinit var viewModel: HomePageViewModel
    private val moviesAdapter by lazy { MoviesAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProviders.of(this).get(HomePageViewModel::class.java)
        return inflater.inflate(R.layout.page_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setAdapter()
        ProgressBarInterface.post().showProgressBar(true)
        viewModel.getAllMovies()
        setListeners()
        setObservers()
    }

    private fun setObservers() {
        viewModel.state.observe(viewLifecycleOwner, Observer { responseState ->
            when (responseState) {
                is ResponseSuccess -> {
                    ProgressBarInterface.post().showProgressBar(false)
                    showError(false)
                    moviesAdapter.setData(responseState.list)
                    showRecycler(true)

                }
                is ResponseFailed -> {
                    ProgressBarInterface.post().showProgressBar(false)
                    showError(true)
                    showRecycler(false)
                }
            }
        })
    }


    private fun setListeners() {
        refreshButton.setOnClickListener {
            viewModel.getAllMovies()
        }
    }

    private fun showRecycler(show: Boolean) {
        movieRecycler.visibility = setVisibility(show)
    }

    private fun showError(show: Boolean) {
        listOf<View>(errorMessage, refreshButton).forEach {
            it.visibility = setVisibility(show)
        }
    }

    private fun setAdapter() {
        movieRecycler.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = this@HomePage.moviesAdapter
        }
        moviesAdapter.onClickAction = {
            findNavController().navigate(
                R.id.action_homePage_to_detailsPage,
                bundleOf(Pair(MOVIE_ID, SingleMovie(it.title, it.characters)))
            )
        }
    }

}