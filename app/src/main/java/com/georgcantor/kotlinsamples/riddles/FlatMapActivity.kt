package com.georgcantor.kotlinsamples.riddles

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.georgcantor.kotlinsamples.R
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_flat_map.*
import java.util.*


class FlatMapActivity : AppCompatActivity() {


    companion object {
        private val cities = Arrays.asList("Moscow", "Dallas", "London", "Chita")

        fun getNumObservable(): Observable<Int> {
            return Observable.just(1, 1, 1, 1, 1, 1, 1)
        }

        fun cityList(): Observable<MutableList<String>>? {
            return Observable.fromArray(cities)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flat_map)

        exampleMap()
    }

    fun execFlatMapClick(view: View) {
        executeFlatMap()
    }

    fun execMergeClick(view: View) {
        executeMerge()
    }

    private fun executeFlatMap() {
        getObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap { int -> multiply(int, 10) }
                .flatMap { int -> multiply(int, 10) }
                .subscribe(getObserver())
    }

    private fun getObservable(): Observable<Int> {
        return Observable.just(1, 2, 3)
    }

    private fun getObserver(): Observer<Int> {
        return object : Observer<Int> {

            override fun onSubscribe(d: Disposable) {
                Toast.makeText(this@FlatMapActivity,
                        "onSubscribe : " + d.isDisposed, Toast.LENGTH_SHORT).show()
            }

            override fun onNext(t: Int) {
                textView_flatmap.append(" onNext : value : $t")
            }

            override fun onError(e: Throwable) {
                textView_flatmap.append("onError : ${e.message}")
            }

            override fun onComplete() {
                Toast.makeText(this@FlatMapActivity,
                        "onComplete", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun multiply(int: Int?, multiplier: Int): Observable<Int>? {
        return Observable.just(int!! * multiplier)
    }


    private fun executeMerge() {
        val cars = arrayOf("Audi", "BMW", "KIA")
        val countries = arrayOf("Russia", "USA", "Canada")

        val carObservable = Observable.fromArray(*cars)
        val countryObservable = Observable.fromArray(*countries)

        Observable.merge(carObservable, countryObservable)
                .subscribe(getStringObserver())
    }

    private fun getStringObserver(): Observer<String> {
        return object : Observer<String> {

            override fun onSubscribe(d: Disposable) {
            }

            override fun onNext(t: String) {
                textView_flatmap.append(" onNext : value : $t")
            }

            override fun onError(e: Throwable) {
            }

            override fun onComplete() {
                Toast.makeText(this@FlatMapActivity,
                        "onComplete getStringObserver()", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun exampleMap() {
        val numbers = arrayOf(1, 2, 3, 4, 5, 6, 7)
        val numObservable = Observable
                .fromArray(*numbers)
                .map { it ->
                    it.plus(10)
                }
                .subscribe(getObserver())
    }
}
