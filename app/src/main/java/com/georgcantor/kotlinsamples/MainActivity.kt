package com.georgcantor.kotlinsamples

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.georgcantor.kotlinsamples.anim.AnimActivity
import com.georgcantor.kotlinsamples.broadcast.BroadcastActivity
import com.georgcantor.kotlinsamples.exoplayer.ExoActivity
import com.georgcantor.kotlinsamples.mvvm.ui.PostListActivity
import com.georgcantor.kotlinsamples.riddles.FlatMapActivity
import com.georgcantor.kotlinsamples.riddles.RiddleActivity
import com.georgcantor.kotlinsamples.riddles.SumActivity
import com.georgcantor.kotlinsamples.rxcalculator.CalcActivity
import com.georgcantor.kotlinsamples.rxclick.RxClickActivity
import com.georgcantor.kotlinsamples.viewmodel.ui.SampleActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun galleryClick(view: View) {
        val intent = Intent(this, CalcActivity::class.java)
        startActivity(intent)
    }

    fun mvvmClick(view: View) {
        val intent = Intent(this, PostListActivity::class.java)
        startActivity(intent)
    }

    fun exoClick(view: View) {
        val intent = Intent(this, ExoActivity::class.java)
        startActivity(intent)
    }

    fun goToBroadcastActivity(view: View) {
        val intent = Intent(this, BroadcastActivity::class.java)
        startActivity(intent)
    }

    fun torchClick(view: View) {
        val intent = Intent(this, RiddleActivity::class.java)
        startActivity(intent)
    }

    fun rxClick(view: View) {
        val intent = Intent(this, RxClickActivity::class.java)
        startActivity(intent)
    }

    fun animClick(view: View) {
        val intent = Intent(this, AnimActivity::class.java)
        startActivity(intent)
    }

    fun flatMapClick(view: View) {
        val intent = Intent(this, SumActivity::class.java)
        startActivity(intent)
    }

    fun zipClick(view: View) {
        val intent = Intent(this, FlatMapActivity::class.java)
        startActivity(intent)
    }

    fun filterClick(view: View) {
        val intent = Intent(this, SampleActivity::class.java)
        startActivity(intent)
    }
}
