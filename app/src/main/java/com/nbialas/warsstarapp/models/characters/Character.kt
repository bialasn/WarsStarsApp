package com.nbialas.warsstarapp.models.characters

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Character(

    @SerializedName("name")
    var characterName: String = ""
):Serializable