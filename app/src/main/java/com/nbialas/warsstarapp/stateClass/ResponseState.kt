package com.nbialas.warsstarapp.stateClass

import com.nbialas.warsstarapp.models.movie.SingleMovie

sealed class ResponseState
class ResponseMoviesSuccess(val listOfMovie: List<SingleMovie>) : ResponseState()
object ResponseMoviesFailed : ResponseState()

class ResponseCharactersSuccess(val listOfCharacters: List<String>) : ResponseState()
object ResponseCharactersFailed : ResponseState()