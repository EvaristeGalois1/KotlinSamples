package com.georgcantor.kotlinsamples.mvvm.ui

import android.arch.lifecycle.MutableLiveData
import com.georgcantor.kotlinsamples.mvvm.base.BaseViewModel
import com.georgcantor.kotlinsamples.mvvm.model.Post

class PostViewModel : BaseViewModel() {
    private val postTitle = MutableLiveData<String>()
    private val postBody = MutableLiveData<String>()

    fun bind(post: Post) {
        postTitle.value = post.title
        postBody.value = post.body
    }

    fun getPostTitle(): MutableLiveData<String> {
        return postTitle
    }

    fun getPostBody(): MutableLiveData<String> {
        return postBody
    }
}