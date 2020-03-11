package com.nbialas.warsstarapp.models.movie

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class MovieResponse(
    @SerializedName("results")
    var results: List<SingleMovie> = listOf()
) : Serializable
