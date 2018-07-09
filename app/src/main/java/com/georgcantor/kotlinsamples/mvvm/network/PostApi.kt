package com.georgcantor.kotlinsamples.mvvm.network

import com.georgcantor.kotlinsamples.mvvm.model.Post
import io.reactivex.Observable
import retrofit2.http.GET

interface PostApi {

    @GET("/posts")
    fun getPosts(): Observable<List<Post>>
}