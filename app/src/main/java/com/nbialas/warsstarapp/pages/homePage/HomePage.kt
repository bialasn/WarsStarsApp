package com.nbialas.warsstarapp.pages.homePage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.nbialas.warsstarapp.R
import com.nbialas.warsstarapp.const.Const.MOVIE_ID
import com.nbialas.warsstarapp.models.movie.SingleMovie
import com.nbialas.warsstarapp.tools.Tools.setVisibility
import kotlinx.android.synthetic.main.page_home.*

class HomePage : Fragment() {

    lateinit var viewModel: HomePageViewModel
    private val adapter by lazy { MoviesAdapter() }


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

        viewModel.getAllMovies()

        setListeners()
    }

    private fun setListeners() {
        viewModel.listOfMovie.observe(viewLifecycleOwner, Observer {
            adapter.setData(it)
        })
        viewModel.showError.observe(viewLifecycleOwner, Observer {
            errorMessage.visibility = setVisibility(it)
        })
        viewModel.showProgressBar.observe(viewLifecycleOwner, Observer {
            progressBar.visibility = setVisibility(it)
        })
    }

    private fun setAdapter() {
        movieRecycler.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = this@HomePage.adapter
        }

        adapter.onClickAction = {
            findNavController().navigate(
                R.id.detailsPage, bundleOf(Pair(MOVIE_ID, SingleMovie(it.title, it.characters)))
            )
        }
    }

}