package com.georgcantor.kotlinsamples.mvvm.ui

import com.georgcantor.kotlinsamples.mvvm.base.BaseViewModel
import com.georgcantor.kotlinsamples.mvvm.model.PostDao
import com.georgcantor.kotlinsamples.mvvm.network.PostApi
import javax.inject.Inject

class PostListViewModel(private val postDao: PostDao) : BaseViewModel() {

    @Inject
    lateinit var postApi: PostApi
}