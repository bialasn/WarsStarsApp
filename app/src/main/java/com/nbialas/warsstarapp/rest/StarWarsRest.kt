package com.nbialas.warsstarapp.rest

import com.google.gson.GsonBuilder
import com.nbialas.warsstarapp.const.Const.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


object StarWarsRest {
    val service: StarWarsApi

    init {
        val httpClient = OkHttpClient.Builder()

        val gson = GsonBuilder().setLenient().create()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(httpClient.build())
            .build()

        service = retrofit.create(StarWarsApi::class.java)
    }

}