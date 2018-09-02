package com.georgcantor.kotlinsamples

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.georgcantor.kotlinsamples.broadcast.BroadcastActivity
import com.georgcantor.kotlinsamples.exoplayer.ExoActivity
import com.georgcantor.kotlinsamples.gallery.SunsetActivity
import com.georgcantor.kotlinsamples.mvvm.ui.PostListActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun galleryClick(view: View) {
        val intent = Intent(this, SunsetActivity::class.java)
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
}
