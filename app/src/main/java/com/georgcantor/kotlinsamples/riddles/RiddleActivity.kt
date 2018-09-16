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
    private lateinit var observable: Observable<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_riddle)

        observable = Observable.range(1, 10)

        list = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    }

    fun justClick(view: View) {
        solve(list)
    }

    fun increaseClick(view: View) {
        increase(observable)
    }

    fun streamClick(view: View) {
        startStream()
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

    private fun increase(source: Observable<Int>) {
        val observer = object : Observer<Int> {

            override fun onSubscribe(d: Disposable) {
                Toast.makeText(this@RiddleActivity,
                        "onSubscribe", Toast.LENGTH_SHORT).show()
            }

            override fun onNext(t: Int) {
                Toast.makeText(this@RiddleActivity,
                        observable.toString(), Toast.LENGTH_SHORT).show()
            }

            override fun onComplete() {
                Toast.makeText(this@RiddleActivity,
                        "onComplete", Toast.LENGTH_SHORT).show()
            }

            override fun onError(e: Throwable) {
                Toast.makeText(this@RiddleActivity,
                        "onError", Toast.LENGTH_SHORT).show()
            }
        }
        observable.subscribe(observer)
    }

    private fun startStream() {
        val myObservable = getObservable()
        val myObserver = getObserver()

        myObservable.subscribe(myObserver)
    }

    private fun getObserver(): Observer<String> {
        return object : Observer<String> {

            override fun onSubscribe(d: Disposable) {
            }

            override fun onNext(t: String) {
                Toast.makeText(this@RiddleActivity,
                        "onNext: $t", Toast.LENGTH_SHORT).show()
            }

            override fun onComplete() {
            }

            override fun onError(e: Throwable) {
            }

        }
    }

    private fun getObservable(): Observable<String> {
        return Observable.just("1", "2", "3", "4")
    }
}
