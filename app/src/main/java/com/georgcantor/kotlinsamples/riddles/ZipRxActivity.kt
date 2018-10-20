package com.georgcantor.kotlinsamples.riddles

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.georgcantor.kotlinsamples.R
import com.georgcantor.kotlinsamples.riddles.model.Player
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.activity_zip_rx.*




class ZipRxActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_zip_rx)
    }

    fun sortNamesakes() {

    }

    private fun getObserver(): Observer<List<Player>> {

        return object : Observer<List<Player>> {

            override fun onSubscribe(d: Disposable) {
            }

            override fun onNext(list: List<Player>) {
                textViewZip.append(" OnNext")
                for (player in list) {
                    textViewZip.append(player.lastName)
                }
            }

            override fun onError(e: Throwable) {
            }

            override fun onComplete() {
            }
        }
    }
}
