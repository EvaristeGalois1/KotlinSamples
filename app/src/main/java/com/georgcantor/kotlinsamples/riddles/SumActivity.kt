package com.georgcantor.kotlinsamples.riddles

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.georgcantor.kotlinsamples.R
import com.jakewharton.rxbinding3.widget.afterTextChangeEvents
import io.reactivex.Observable
import io.reactivex.ObservableOnSubscribe
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.activity_sum.*
import java.util.concurrent.TimeUnit


class SumActivity : AppCompatActivity() {

    @SuppressLint("CheckResult", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sum)

        execute()

        textViewDebounce.afterTextChangeEvents()
                .debounce(2000, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { _ ->
                    textViewDebounce.text = "Output : " + editTextDebounce.text
                }
    }

    private fun execute() {
        observable.subscribe(observer)
    }

    private var observable = Observable.create(ObservableOnSubscribe<Int> { e ->
        e.onNext(1)
        e.onNext(2)
        e.onNext(3)
        e.onNext(4)
        e.onComplete()
    })

    private var observer: Observer<Int> = object : Observer<Int> {

        override fun onComplete() {
        }

        override fun onSubscribe(d: Disposable) {
        }

        override fun onNext(t: Int) {
            Toast.makeText(this@SumActivity, "item: $t", Toast.LENGTH_SHORT).show()
        }

        override fun onError(e: Throwable) {
        }
    }
}
