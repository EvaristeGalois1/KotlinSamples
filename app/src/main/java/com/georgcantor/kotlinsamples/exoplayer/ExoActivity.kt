package com.georgcantor.kotlinsamples.exoplayer

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.georgcantor.kotlinsamples.R

class ExoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exo)

        val radioButton = findViewById<View>(R.id.btn_radio)
        val videoButton = findViewById<View>(R.id.btn_video)

        radioButton.setOnClickListener {
            val intent = Intent(this, RadioActivity::class.java)
            startActivity(intent)
        }

        videoButton.setOnClickListener {
            val intent = Intent(this, VideoActivity::class.java)
            startActivity(intent)
        }
    }
}