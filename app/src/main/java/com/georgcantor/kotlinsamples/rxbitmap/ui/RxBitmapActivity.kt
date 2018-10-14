package com.georgcantor.kotlinsamples.rxbitmap.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.georgcantor.kotlinsamples.R
import com.georgcantor.kotlinsamples.rxbitmap.repo.ImageRepository
import kotlinx.android.synthetic.main.activity_rx_bitmap.*

class RxBitmapActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rx_bitmap)

        val viewModel = FlatMapViewModel(ImageRepository(this))
        appleButton.setOnClickListener { viewModel.onBtnClick("apple") }
        bananaButton.setOnClickListener { viewModel.onBtnClick("banana") }
        orangeButton.setOnClickListener { viewModel.onBtnClick("orange") }

        viewModel.images()
                .subscribe { imageViewRxBitmap.setImageBitmap(it) }
    }
}
