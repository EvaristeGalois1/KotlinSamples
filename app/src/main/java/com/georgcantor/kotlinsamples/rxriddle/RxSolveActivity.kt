package com.georgcantor.kotlinsamples.rxriddle

import android.content.Intent
import android.os.Bundle
import android.support.annotation.NonNull
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.georgcantor.kotlinsamples.R
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
import io.reactivex.subjects.BehaviorSubject


class RxSolveActivity : AppCompatActivity() {

    private lateinit var subscription: Disposable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rx_solve)

//        subject()
//        ints()
    }

//    private fun subject() {
//        val publishSubject = PublishSubject.create<Int>()
//
//        subscription = publishSubject.subscribe { integer ->
//            Toast.makeText(this@RxSolveActivity,
//                    integer.toString(), Toast.LENGTH_SHORT).show()
//        }
//
//        publishSubject.onNext(1)
//        publishSubject.onNext(8)
//        publishSubject.onNext(0)
//    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//        subscription.dispose()
//    }

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
//            override fun onSubscribe(decimalFormat: Disposable) {
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

    fun subjectClick(view: View) {
        val string = "Sample"
        RxBus.publish(string)

        startActivity(Intent(this, ReceiveActivity::class.java))
    }

    object RxBus {
        private val behaviorSubject = BehaviorSubject.create<Any>()

        fun subscribe(@NonNull action: Consumer<Any>): Disposable {
            return behaviorSubject.subscribe(action)
        }

        fun publish(@NonNull message: Any) {
            behaviorSubject.onNext(message)
        }
    }
}
