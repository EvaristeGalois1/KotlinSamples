package com.georgcantor.kotlinsamples.rxbitmap.ui

import android.graphics.Bitmap
import com.georgcantor.kotlinsamples.rxbitmap.repo.ImageRepository
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.subjects.BehaviorSubject

class FlatMapViewModel(private val repo: ImageRepository) {

    private val clickEvents = BehaviorSubject.create<String>()

    fun images(): Observable<Bitmap> = clickEvents
            .flatMapSingle { repo.image(it) }
            .observeOn(AndroidSchedulers.mainThread())

    fun onBtnClick(text: String) {
        clickEvents.onNext(text)
    }
}