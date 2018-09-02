package com.georgcantor.kotlinsamples.torch

import android.annotation.TargetApi
import android.content.Context
import android.content.DialogInterface
import android.content.pm.PackageManager
import android.hardware.camera2.CameraAccessException
import android.hardware.camera2.CameraManager
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.georgcantor.kotlinsamples.R
import kotlinx.android.synthetic.main.activity_torch.*


class TorchActivity : AppCompatActivity() {

    companion object {
        const val CAMERA_REQUEST_CODE = 111
    }

    private var cameraManager: CameraManager? = null
    private lateinit var cameraId: String

    @TargetApi(Build.VERSION_CODES.M)
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_torch)

        setupPermission()

        val isFlashAvailable = applicationContext.packageManager
                .hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH)

        if (!isFlashAvailable) {
            setupPermission()
            showNoFlashError()
        }

        cameraManager = getSystemService(Context.CAMERA_SERVICE) as CameraManager
        try {
            cameraId = cameraManager!!.cameraIdList[0]
        } catch (e: CameraAccessException) {
            e.printStackTrace()
        }

        toggleButton.setOnCheckedChangeListener { _, isChecked ->
            switchFlashLight(isChecked)
        }
    }

    private fun setupPermission() {
        Toast.makeText(this, "проверка", Toast.LENGTH_SHORT).show()
        val permission = ContextCompat.checkSelfPermission(this,
                android.Manifest.permission.CAMERA)
        if (permission != PackageManager.PERMISSION_GRANTED) {
            requestPermission()
        }
    }

    private fun requestPermission() {
        Toast.makeText(this, "запрос", Toast.LENGTH_SHORT).show()
        ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CAMERA),
                CAMERA_REQUEST_CODE)
    }

    private fun showNoFlashError() {
        val alert = AlertDialog.Builder(this).create()
        alert.setTitle(getString(R.string.oops_alert_dialog))
        alert.setMessage(getString(R.string.alert_message))
        alert.setButton(DialogInterface.BUTTON_POSITIVE, "OK") { _, _ ->
            finish()
        }
        alert.show()
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun switchFlashLight(status: Boolean) {
        try {
            cameraManager?.setTorchMode(cameraId, status)
        } catch (e: CameraAccessException) {
            e.printStackTrace()
        }

    }
}
