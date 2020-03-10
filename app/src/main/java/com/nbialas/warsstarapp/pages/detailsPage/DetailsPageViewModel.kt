package com.nbialas.warsstarapp.pages.detailsPage

import androidx.lifecycle.ViewModel

class DetailsPageViewModel : ViewModel() {
    var movieTitle: String = ""
    var charactersList = listOf<String>()

    //dokonczyc
    fun prepareList(){
        for (character in charactersList){
           val a = character.replace("https://swapi.co/api/people/","")

        }
    }
}