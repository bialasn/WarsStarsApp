package com.nbialas.warsstarapp.models.movie

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SingleMovie(
    @SerializedName("title")
    val title: String,

    @SerializedName("characters")
    val characters: ArrayList<String> = arrayListOf()

) : Parcelable
