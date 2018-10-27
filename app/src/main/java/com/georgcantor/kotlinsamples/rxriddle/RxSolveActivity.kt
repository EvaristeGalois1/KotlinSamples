package com.georgcantor.kotlinsamples.rxriddle

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.georgcantor.kotlinsamples.R
import io.reactivex.disposables.Disposable
import io.reactivex.subjects.PublishSubject


class RxSolveActivity : AppCompatActivity() {

    private lateinit var subscription: Disposable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rx_solve)

        subject()
//        ints()
    }

    private fun subject() {
        val publishSubject = PublishSubject.create<Int>()

        subscription = publishSubject.subscribe { integer ->
            Toast.makeText(this@RxSolveActivity,
                    integer.toString(), Toast.LENGTH_SHORT).show()
        }

        publishSubject.onNext(1)
        publishSubject.onNext(8)
        publishSubject.onNext(0)
    }

    override fun onDestroy() {
        super.onDestroy()
        subscription.dispose()
    }

//    private fun ints() {
//        return Observable.just(1, 2, 3, 4, 5, 6, 7)
//                .filter { t ->
//                    t % 2 == 0
//                }
//                .subscribe(getObserver())
//    }
//
//
//    private fun getObserver(): Observer<Int> {
//        return object : Observer<Int> {
//
//            override fun onSubscribe(d: Disposable) {
//            }
//
//            override fun onNext(t: Int) {
//                Toast.makeText(this@RxSolveActivity,
//                        "onNext: $t", Toast.LENGTH_SHORT).show()
//            }
//
//            override fun onComplete() {
//            }
//
//            override fun onError(e: Throwable) {
//            }
//        }
//    }
}
