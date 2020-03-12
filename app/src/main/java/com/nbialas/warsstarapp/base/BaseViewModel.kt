package com.nbialas.warsstarapp.base

import android.view.View
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel : ViewModel() {

    var rxDisposer: CompositeDisposable = CompositeDisposable()

    fun setVisibility(show: Boolean): Int {
        return if (show) {
            View.VISIBLE
        } else {
            View.GONE
        }
    }

    override fun onCleared() {
        super.onCleared()
        rxDisposer.dispose()
    }
}