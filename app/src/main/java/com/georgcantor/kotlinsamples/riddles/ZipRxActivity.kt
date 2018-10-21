package com.georgcantor.kotlinsamples.riddles

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.georgcantor.kotlinsamples.R
import com.georgcantor.kotlinsamples.riddles.model.Player
import com.georgcantor.kotlinsamples.riddles.utils.UtilRx
import io.reactivex.Observable
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

    private fun footballplayers(): Observable<List<Player>> {
        return Observable
                .create<List<Player>> { it ->
                    if (!it.isDisposed) {
                        it.onNext(UtilRx.footballPLayers())
                        it.onComplete()
                    }
                }
    }

    private fun hockeyPlayers(): Observable<List<Player>> {
        return Observable
                .create<List<Player>> { it ->
                    if (!it.isDisposed) {
                        it.onNext(UtilRx.hockeyPlayers())
                        it.onComplete()
                    }
                }
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
