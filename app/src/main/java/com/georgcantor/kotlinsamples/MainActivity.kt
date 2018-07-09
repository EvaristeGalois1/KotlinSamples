package com.georgcantor.kotlinsamples

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.georgcantor.kotlinsamples.gallery.SunsetActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun galleryClick(view: View) {
        val intent = Intent(this, SunsetActivity::class.java)
        startActivity(intent)
    }
}
