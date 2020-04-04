package com.nbialas.warsstarapp.stateClass

import com.nbialas.warsstarapp.models.movie.SingleMovie

sealed class ResponseState
class ResponseSuccess(val list: List<SingleMovie>) : ResponseState()
object ResponseFailed : ResponseState()

