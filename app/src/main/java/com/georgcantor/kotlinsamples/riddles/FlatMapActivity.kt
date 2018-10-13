package com.georgcantor.kotlinsamples.riddles

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.georgcantor.kotlinsamples.R
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

class FlatMapActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flat_map)
    }

    private fun executeFlatMapOperator() {

    }

    private fun getObservable(): Observable<Int> {
        return Observable.just(9, 8, 7, 6, 5)
    }

    private fun getObserver(): Observer<Int> {

        return object: Observer<Int> {

            override fun onComplete() {
            }

            override fun onSubscribe(d: Disposable) {
            }

            override fun onNext(t: Int) {
            }

            override fun onError(e: Throwable) {
            }

        }
    }
}
