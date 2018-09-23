package com.georgcantor.kotlinsamples.anim

import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.constraint.ConstraintSet
import android.support.transition.ChangeBounds
import android.support.transition.TransitionManager
import android.support.v7.app.AppCompatActivity
import android.view.animation.AnticipateInterpolator
import com.georgcantor.kotlinsamples.R
import kotlinx.android.synthetic.main.activity_anim.*


class AnimActivity : AppCompatActivity() {

    private var show: Boolean = false
    private lateinit var constraintLayout: ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anim)

        constraintLayout = findViewById(R.id.cc1)
        backgroundImage.setOnClickListener {
            if (show) {
                revertAnimation()
            } else {
                showAnimation()
            }
        }
    }

    private fun showAnimation() {
        show = true

        val constraintSet = ConstraintSet()
        constraintSet.clone(this, R.layout.activity_anim_animated)

        val transition = ChangeBounds()
        transition.interpolator = AnticipateInterpolator(1.0f)
        transition.duration = 1200

        TransitionManager.beginDelayedTransition(cc1, transition)
        constraintSet.applyTo(cc1)
    }

    private fun revertAnimation() {
        show = false

        val constraintSet = ConstraintSet()
        constraintSet.clone(this, R.layout.activity_main)

        val transition = ChangeBounds()
        transition.interpolator = AnticipateInterpolator(1.0f)
        transition.duration = 1200

        TransitionManager.beginDelayedTransition(cc1, transition)
        constraintSet.applyTo(cc1)
    }
}
