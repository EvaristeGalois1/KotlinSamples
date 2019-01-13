package com.georgcantor.kotlinsamples.pedometr

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.georgcantor.kotlinsamples.R
import kotlinx.android.synthetic.main.activity_metr.*


class MetrActivity : AppCompatActivity(), SensorEventListener {

    lateinit var sensorManager: SensorManager
    private val isRunning = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_metr)

        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
    }

    @RequiresApi(Build.VERSION_CODES.KITKAT)
    override fun onResume() {
        super.onResume()
        isRunning

        val countSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)

        if (countSensor != null) {
            sensorManager.registerListener(this, countSensor,
                    SensorManager.SENSOR_DELAY_UI)
        } else {
            Toast.makeText(this, "Sensor not found", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onPause() {
        super.onPause()
        !isRunning
    }

    override fun onSensorChanged(event: SensorEvent?) {
        if (event != null) {
            tv_steps.text = event.values[0].toString()
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
    }
}
