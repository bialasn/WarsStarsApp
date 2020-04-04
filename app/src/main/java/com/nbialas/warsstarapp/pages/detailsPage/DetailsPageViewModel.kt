package com.nbialas.warsstarapp.pages.detailsPage

import androidx.lifecycle.MutableLiveData
import com.nbialas.warsstarapp.base.BaseViewModel
import com.nbialas.warsstarapp.const.Const.CHARACTER_PREFIX
import com.nbialas.warsstarapp.models.movie.SingleMovie
import com.nbialas.warsstarapp.rest.StarWarsRest
import com.nbialas.warsstarapp.stateClass.ResponseCharactersFailed
import com.nbialas.warsstarapp.stateClass.ResponseCharactersSuccess
import com.nbialas.warsstarapp.stateClass.ResponseState
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class DetailsPageViewModel : BaseViewModel() {
    var state = MutableLiveData<ResponseState>()
    var singleMovie = MutableLiveData<SingleMovie>()

    private var charactersList = listOf<String>()
    private var listToAdapter = arrayListOf<String>()

    private fun prepareCharacterList(movie: SingleMovie) {
        charactersList = movie.characters.map {
            it.replace(CHARACTER_PREFIX, "")
        }
        if (charactersList.isNotEmpty()) {
            charactersList.forEach {
                getCharactersFromSWAPI(it)
            }
        } else state.postValue(ResponseCharactersFailed)
    }


    private fun getCharactersFromSWAPI(name: String) {
        rxDisposer.add(
            StarWarsRest.service.singleCharacter(name).subscribeOn(Schedulers.io()).observeOn(
                AndroidSchedulers.mainThread()
            ).subscribe({
                listToAdapter.add(it.characterName)
                if (listToAdapter.size == charactersList.size) {
                    state.postValue(ResponseCharactersSuccess(listToAdapter))
                }
            }, {
                state.postValue(ResponseCharactersFailed)
            })
        )
    }

    fun setSingleMovieValue(movie: SingleMovie) {
        singleMovie.postValue(movie)
        prepareCharacterList(movie)
    }
}