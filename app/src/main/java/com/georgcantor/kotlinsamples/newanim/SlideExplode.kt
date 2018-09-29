package com.georgcantor.kotlinsamples.newanim

import android.graphics.Rect
import android.os.Build
import android.support.annotation.RequiresApi
import android.transition.TransitionValues
import android.transition.Visibility

private const val KEY_SCREEN_BOUNDS = "screenBounds"

/**
 * A simple Transition which allows the views above the epic centre to transition upwards and views
 * below the epic centre to transition downwards.
 */
@RequiresApi(Build.VERSION_CODES.KITKAT)
class SlideExplode : Visibility() {

    private val mTempLoc = IntArray(2)

    private fun captureValues(transitionValues: TransitionValues) {
        val view = transitionValues.view
        view.getLocationOnScreen(mTempLoc)
        val left = mTempLoc[0]
        val top = mTempLoc[1]
        val right = left + view.width
        val bottom = top + view.height
        transitionValues.values[KEY_SCREEN_BOUNDS] = Rect(left, top, right, bottom)
    }
}