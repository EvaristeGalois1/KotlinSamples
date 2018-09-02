package com.georgcantor.kotlinsamples.broadcast

import android.bluetooth.BluetoothAdapter
import android.content.BroadcastReceiver
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.support.v4.content.LocalBroadcastManager
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.georgcantor.kotlinsamples.R

class BroadcastActivity : AppCompatActivity() {

    private val BROADCAST = "com.example.broadcast.MY_NOTIFICATION"
    private var receiver: BroadcastReceiver = MyReceiver()
    private var localBroadcastManager: LocalBroadcastManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_broadcast)

        val filter = IntentFilter(Intent.ACTION_POWER_CONNECTED)
        filter.addAction(Intent.ACTION_POWER_DISCONNECTED)
        filter.addAction(BluetoothAdapter.ACTION_STATE_CHANGED)
        this.registerReceiver(receiver, filter)
    }

    fun broadcastClick(v: View?) {
        val intent = Intent()
        intent.action = BROADCAST
        intent.putExtra("data", "Broadcast!")
        if (localBroadcastManager == null) {
            localBroadcastManager = LocalBroadcastManager.getInstance(this)
            localBroadcastManager?.registerReceiver(receiver, IntentFilter(BROADCAST))
        }
        localBroadcastManager?.sendBroadcast(intent)
    }

    override fun onDestroy() {
        unregisterReceiver(receiver)
        localBroadcastManager?.unregisterReceiver(receiver)
        super.onDestroy()
    }
}
