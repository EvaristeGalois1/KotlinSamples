package com.georgcantor.kotlinsamples.mvvm.base

import android.arch.lifecycle.ViewModel
import com.georgcantor.kotlinsamples.mvvm.di.component.DaggerViewModelInjector
import com.georgcantor.kotlinsamples.mvvm.di.component.ViewModelInjector
import com.georgcantor.kotlinsamples.mvvm.di.module.NetworkModule
import com.georgcantor.kotlinsamples.mvvm.ui.PostListViewModel

abstract class BaseViewModel : ViewModel() {

    private val injector: ViewModelInjector = DaggerViewModelInjector.builder()
            .networkModule(NetworkModule)
            .build()

    init {
        inject()
    }

    private fun inject() {
        when (this) {
            is PostListViewModel -> injector.inject(this)
        }
    }
}