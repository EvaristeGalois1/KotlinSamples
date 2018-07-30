package com.georgcantor.kotlinsamples.exoplayer

import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.georgcantor.kotlinsamples.R
import com.google.android.exoplayer2.ExoPlayerFactory
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory
import com.google.android.exoplayer2.source.ExtractorMediaSource
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.util.Util

class RadioActivity : AppCompatActivity() {

    companion object {
        const val RADIO_URL = "http://rs1.radiostreamer.com:8030"
    }

    private lateinit var player: SimpleExoPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_radio)

        val playButton = findViewById<View>(R.id.btn_play)
        val stopButton = findViewById<View>(R.id.btn_stop)

        initPlayer()
    }

    private fun initPlayer() {
        val bandwidthMeter = DefaultBandwidthMeter()
        val extractorsFactory = DefaultExtractorsFactory()
        val trackSelectionFactory = AdaptiveTrackSelection.Factory(bandwidthMeter)
        val trackSelector = DefaultTrackSelector(trackSelectionFactory)
        val defaultBandwidthMeter = DefaultBandwidthMeter()
        val dataSourceFactory = DefaultDataSourceFactory(this, Util.getUserAgent(this,
                "mediaPlayerSample"), defaultBandwidthMeter)
        val mediaSource = ExtractorMediaSource(Uri.parse(RADIO_URL),
                dataSourceFactory, extractorsFactory, null, null)
        player = ExoPlayerFactory.newSimpleInstance(this, trackSelector)
        player.prepare(mediaSource)
    }

    override fun onDestroy() {
        super.onDestroy()
        player.playWhenReady = false
    }
}
