package com.georgcantor.kotlinsamples.viewmodel.network

import com.georgcantor.kotlinsamples.viewmodel.model.MenuItem
import retrofit2.Call
import retrofit2.http.GET

interface RestService {

    @GET("menu.json")
    fun getMenu(): Call<List<MenuItem>>
}