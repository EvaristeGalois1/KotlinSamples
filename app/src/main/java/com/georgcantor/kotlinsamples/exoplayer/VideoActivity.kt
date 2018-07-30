package com.georgcantor.kotlinsamples.exoplayer

import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.georgcantor.kotlinsamples.R
import com.google.android.exoplayer2.ExoPlayerFactory
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory
import com.google.android.exoplayer2.source.ExtractorMediaSource
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.ui.SimpleExoPlayerView
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.upstream.TransferListener
import com.google.android.exoplayer2.util.Util

class VideoActivity : AppCompatActivity() {

    companion object {
        const val VIDEO_URL = "http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4"
    }

    private lateinit var player: SimpleExoPlayer
    private var shouldAutoPlay: Boolean = false
    private lateinit var trackSelector: DefaultTrackSelector

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video)
        shouldAutoPlay = true
    }

    private fun initPlayer() {
        val simpleExoPlayerView = findViewById<SimpleExoPlayerView>(R.id.player_view)
        val bandwidthMeter = DefaultBandwidthMeter()
        val extractorsFactory = DefaultExtractorsFactory()
        val videoTrackSelectionFactory = AdaptiveTrackSelection.Factory(bandwidthMeter)
        val mediaDataSourceFactory = DefaultDataSourceFactory(this,
                Util.getUserAgent(this, "mediaPlayerSample"),
                bandwidthMeter as TransferListener<in DataSource>)
        val mediaSource = ExtractorMediaSource(Uri.parse(VIDEO_URL),
                mediaDataSourceFactory, extractorsFactory, null, null)

        simpleExoPlayerView?.requestFocus()
        trackSelector = DefaultTrackSelector(videoTrackSelectionFactory)

        player = ExoPlayerFactory.newSimpleInstance(this, trackSelector)

        simpleExoPlayerView?.player = player
        player.playWhenReady = shouldAutoPlay
        player.prepare(mediaSource)
    }

    private fun releasePlayer() {
        player.release()
        shouldAutoPlay = player.playWhenReady
    }

    override fun onStart() {
        super.onStart()
        if (Util.SDK_INT > 23) {
            initPlayer()
        }
    }

    override fun onResume() {
        super.onResume()
        if ((Util.SDK_INT <= 23)) {
            initPlayer()
        }
    }

    override fun onPause() {
        super.onPause()
        if (Util.SDK_INT <= 23) {
            releasePlayer()
        }
    }

    override fun onStop() {
        super.onStop()
        if (Util.SDK_INT > 23) {
            releasePlayer()
        }
    }
}
