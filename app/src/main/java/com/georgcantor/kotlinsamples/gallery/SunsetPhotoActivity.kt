package com.georgcantor.kotlinsamples.gallery

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView

class SunsetPhotoActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_SUNSET_PHOTO = "SunsetPhotoActivity.EXTRA_SUNSET_PHOTO"
    }

    private lateinit var imageView: ImageView
    private lateinit var sunsetPhoto: SunsetPhoto

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}