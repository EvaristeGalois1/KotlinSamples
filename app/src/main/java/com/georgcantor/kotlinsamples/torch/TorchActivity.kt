package com.georgcantor.kotlinsamples.torch

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.georgcantor.kotlinsamples.R
import kotlinx.android.synthetic.main.activity_torch.*
import android.widget.CompoundButton
import android.content.pm.PackageManager
import android.hardware.camera2.CameraAccessException
import android.hardware.camera2.CameraManager
import android.os.Build
import android.support.annotation.RequiresApi


class TorchActivity : AppCompatActivity() {

    private var cameraManager: CameraManager? = null
    private lateinit var cameraId: String

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_torch)

        val isFlashAvailable = applicationContext.packageManager
                .hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH)

        if (!isFlashAvailable) {
            showNoFlashError()
        }

        cameraManager = getSystemService(Context.CAMERA_SERVICE) as CameraManager
        try {
            cameraId = cameraManager!!.cameraIdList[0]
        } catch (e: CameraAccessException) {
            e.printStackTrace()
        }


        toggleButton.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener())
    }

    private fun showNoFlashError() {
    }
}
