package com.nbialas.warsstarapp.pages.homePage

import androidx.lifecycle.MutableLiveData
import com.nbialas.warsstarapp.base.BaseViewModel
import com.nbialas.warsstarapp.rest.StarWarsRest
import com.nbialas.warsstarapp.stateClass.ResponseMoviesFailed
import com.nbialas.warsstarapp.stateClass.ResponseMoviesSuccess
import com.nbialas.warsstarapp.stateClass.ResponseState
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class HomePageViewModel : BaseViewModel() {
    var state = MutableLiveData<ResponseState>()


    fun getAllMovies() {
        rxDisposer.add(
            StarWarsRest.service.allMovies().subscribeOn(Schedulers.io()).observeOn(
                AndroidSchedulers.mainThread()
            ).subscribe({
                state.postValue(ResponseMoviesSuccess(it.results))
            }, {
                state.postValue(ResponseMoviesFailed)
            })
        )
    }
}