package com.nbialas.warsstarapp.rest

import com.nbialas.warsstarapp.models.characters.Character
import com.nbialas.warsstarapp.models.movie.MovieResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path


interface StarWarsApi {
    @GET("films")
    fun allMovies(): Observable<MovieResponse>

    @GET("people/{characterId}")
    fun singleCharacter(@Path("characterId") personId: String): Observable<Character>
}