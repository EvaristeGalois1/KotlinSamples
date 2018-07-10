package com.georgcantor.kotlinsamples.mvvm.di.component

import com.georgcantor.kotlinsamples.mvvm.di.module.NetworkModule
import com.georgcantor.kotlinsamples.mvvm.ui.PostListViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(NetworkModule::class)])
interface ViewModelInjector {

    fun inject(postListViewModel: PostListViewModel)

    @Component.Builder
    interface Builder {
        fun build(): ViewModelInjector

        fun networkModule(networkModule: NetworkModule): Builder
    }
}