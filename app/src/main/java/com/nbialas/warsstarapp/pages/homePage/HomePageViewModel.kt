package com.nbialas.warsstarapp.pages.homePage

import androidx.lifecycle.MutableLiveData
import com.nbialas.warsstarapp.base.BaseViewModel
import com.nbialas.warsstarapp.models.movie.SingleMovie
import com.nbialas.warsstarapp.rest.StarWarsRest
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class HomePageViewModel : BaseViewModel() {
    var listOfMovie = MutableLiveData<List<SingleMovie>>()
    var showError = MutableLiveData<Boolean>(false)
    var showProgressBar = MutableLiveData<Boolean>()

    fun getAllMovies() {
        showProgressBar.postValue(true)
        rxDisposer.add(
            StarWarsRest.service.allMovies().subscribeOn(Schedulers.io()).observeOn(
                AndroidSchedulers.mainThread()
            ).subscribe({
                listOfMovie.postValue(it.results)
                showError.postValue(false)
                showProgressBar.postValue(false)
            }, {
                showError.postValue(true)
                showProgressBar.postValue(false)

            })
        )
    }
}