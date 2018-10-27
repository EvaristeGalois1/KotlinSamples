package com.georgcantor.kotlinsamples.rxriddle

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.georgcantor.kotlinsamples.R
import com.georgcantor.kotlinsamples.rxriddle.RxSolveActivity.RxBus
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer


class ReceiveActivity : AppCompatActivity() {

    lateinit var disposable: Disposable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_receive)

        disposable = RxBus.subscribe(Consumer { it ->
            if (it is String) {
                Toast.makeText(this@ReceiveActivity, it, Toast.LENGTH_SHORT).show()
            }
        })
    }
}
