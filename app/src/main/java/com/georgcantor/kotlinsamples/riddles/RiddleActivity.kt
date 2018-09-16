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

    private lateinit var list: List<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_riddle)

        list = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    }

    fun justClick(view: View) {
        solve(list)
    }

    private fun solve(list: List<Int>): Observable<List<Int>>? {
        val valueObservable = Observable.just(list)

        valueObservable.subscribe(object : Observer<List<Int>> {

            override fun onNext(t: List<Int>) {
                Toast.makeText(this@RiddleActivity,
                        "onNext", Toast.LENGTH_SHORT).show()
            }

            override fun onComplete() {
                Toast.makeText(this@RiddleActivity,
                        list.toString(), Toast.LENGTH_SHORT).show()
            }

            override fun onSubscribe(d: Disposable) {
                Toast.makeText(this@RiddleActivity,
                        "onSubscribe", Toast.LENGTH_SHORT).show()
            }

            override fun onError(e: Throwable) {
            }
        })
        return valueObservable
    }
}
