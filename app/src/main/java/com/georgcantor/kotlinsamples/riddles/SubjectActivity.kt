package com.georgcantor.kotlinsamples.riddles

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.georgcantor.kotlinsamples.R
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.reactivex.subjects.BehaviorSubject
import kotlinx.android.synthetic.main.activity_subject.*

class SubjectActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_subject)
    }

    fun behaviorSubjectClick(view: View) {
        executeBehaviorSubject()
    }

    private fun executeBehaviorSubject() {
        val source = BehaviorSubject.create<Int>()

        source.subscribe(firstObserver())
        source.onNext(3)
        source.onNext(4)
        source.onNext(5)
        source.onNext(6)

        source.subscribe(secondObserver())
        source.onNext(7)
        source.onNext(8)
        source.onNext(9)

        source.onComplete()
    }

    private fun firstObserver(): Observer<Int> {
        return object : Observer<Int> {

            override fun onSubscribe(d: Disposable) {
            }

            override fun onNext(t: Int) {
                textViewSubject.append(" First onNext : " + t.toString())
            }

            override fun onError(e: Throwable) {
            }

            override fun onComplete() {
            }
        }
    }

    private fun secondObserver(): Observer<Int> {
        return object : Observer<Int> {

            override fun onSubscribe(d: Disposable) {
            }

            override fun onNext(t: Int) {
                textViewSubject.append(" Second onNext : " + t.toString())
            }

            override fun onError(e: Throwable) {
            }

            override fun onComplete() {
            }
        }
    }
}
