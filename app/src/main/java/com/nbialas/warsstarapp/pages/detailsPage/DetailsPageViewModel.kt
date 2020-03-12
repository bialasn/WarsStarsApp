package com.nbialas.warsstarapp.pages.detailsPage

import androidx.lifecycle.MutableLiveData
import com.nbialas.warsstarapp.base.BaseViewModel
import com.nbialas.warsstarapp.const.Const.CHARACTER_PREFIX
import com.nbialas.warsstarapp.rest.StarWarsRest
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class DetailsPageViewModel : BaseViewModel() {
    var isDataReadyToShow = MutableLiveData<Boolean>(false)
    var movieTitle: String = ""

    var charactersList = listOf<String>()
    var listToAdapter = arrayListOf<String>()

    var showProgressBar = MutableLiveData<Boolean>()
    var showError = MutableLiveData<Boolean>(false)


    fun prepareList() {
        charactersList = charactersList.map { it.replace(CHARACTER_PREFIX, "") }
        charactersList.forEach {
            getCharactersFromSWAPI(it)
        }
    }

    private fun getCharactersFromSWAPI(name: String) {
        showProgressBar.postValue(true)
        rxDisposer.add(
            StarWarsRest.service.singleCharacter(name).subscribeOn(Schedulers.io()).observeOn(
                AndroidSchedulers.mainThread()
            ).subscribe({
                listToAdapter.add(it.characterName)
                if (listToAdapter.size == charactersList.size) {
                    isDataReadyToShow.postValue(true)
                    showProgressBar.postValue(false)
                    showError.postValue(false)
                }
            }, {
                showError.postValue(true)
                showProgressBar.postValue(false)
            })
        )
    }
}