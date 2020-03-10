package com.nbialas.warsstarapp.rest

import com.nbialas.warsstarapp.models.movie.MovieResponse
import io.reactivex.Observable
import retrofit2.http.GET


interface StarWarsApi {
    @GET("films")
    fun allMovies(): Observable<MovieResponse>

//    @GET("people/{personId}")
//    fun singleCharacters(@Path("personId") personId: String): Observable<>
}