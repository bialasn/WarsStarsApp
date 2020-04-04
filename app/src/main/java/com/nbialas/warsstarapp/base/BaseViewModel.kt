package com.nbialas.warsstarapp.base

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel : ViewModel() {

    var rxDisposer: CompositeDisposable = CompositeDisposable()

    override fun onCleared() {
        super.onCleared()
        rxDisposer.dispose()
    }
}