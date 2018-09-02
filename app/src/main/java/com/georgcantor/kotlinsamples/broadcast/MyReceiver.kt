package com.georgcantor.kotlinsamples.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MyReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        val stringBuilder = StringBuilder()
        if (intent != null) {
            stringBuilder.append("Action: " + intent.action + "\n")
            stringBuilder.append("URI: " + intent.toUri(Intent.URI_INTENT_SCHEME).toString() + "\n")
            val log = stringBuilder.toString()
            Toast.makeText(context, log, Toast.LENGTH_LONG).show()
        }
    }
}