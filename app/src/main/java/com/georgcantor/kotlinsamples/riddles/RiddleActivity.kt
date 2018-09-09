package com.georgcantor.kotlinsamples.riddles

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.georgcantor.kotlinsamples.R
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable


class RiddleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_riddle)
    }

    fun justClick(view: View) {
        solve(1)
    }

    private fun solve(value: Int): Observable<Int> {
        val valueObservable = Observable.just(value)

        valueObservable.subscribe(object : Observer<Int> {
            override fun onComplete() {
                Toast.makeText(this@RiddleActivity,
                        value.toString(), Toast.LENGTH_SHORT).show()
            }

            override fun onSubscribe(d: Disposable) {
            }

            override fun onNext(t: Int) {
                Toast.makeText(this@RiddleActivity,
                        "onNext", Toast.LENGTH_SHORT).show()
            }

            override fun onError(e: Throwable) {
            }
        })
        return valueObservable
    }
}
