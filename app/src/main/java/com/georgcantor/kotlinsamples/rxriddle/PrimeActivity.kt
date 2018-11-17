package com.georgcantor.kotlinsamples.rxriddle

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.georgcantor.kotlinsamples.R
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_prime.*

class PrimeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prime)

        getPrimes()
    }

    private fun getPrimes() {
        Observable.range(0, Integer.MAX_VALUE)
                .skip(2)
                .filter(this::isPrime)
                .takeWhile { integer -> integer < 100 }
                .map { it.toString() }
                .reduce { s1, s2 -> "$s1 $s2" }
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { getObserver(it) }
    }

    private fun getObserver(number: String): Observer<Int> {
        return object : Observer<Int> {

            override fun onSubscribe(d: Disposable) {
            }

            override fun onNext(t: Int) {
                textViewPrime.append(" prime : $number")
            }

            override fun onComplete() {
            }

            override fun onError(e: Throwable) {
            }
        }
    }

    private fun isPrime(number: Int): Boolean {
        for (i in 2 until number) {
            if (number % i == 0) return false
        }

        return true
    }
}
