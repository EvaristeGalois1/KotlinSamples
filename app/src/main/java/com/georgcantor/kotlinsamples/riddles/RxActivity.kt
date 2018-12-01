package com.georgcantor.kotlinsamples.riddles

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.georgcantor.kotlinsamples.R
import io.reactivex.Observable

class RxActivity : AppCompatActivity() {

    private lateinit var observable: Observable<Int>

    lateinit var list1: List<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rx)
    }

    fun startEmitClick(view: View) {
        emit()
    }

    private fun emit() {
        observable = Observable.just(1, 2, 3, 4, 5)

        list1 = observable.toList().blockingGet()

        Toast.makeText(this, list1.toString(), Toast.LENGTH_LONG).show()
    }
}
