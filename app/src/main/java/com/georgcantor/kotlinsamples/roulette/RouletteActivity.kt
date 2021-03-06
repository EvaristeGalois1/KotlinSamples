package com.georgcantor.kotlinsamples.roulette

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.animation.Animation
import android.view.animation.DecelerateInterpolator
import android.view.animation.RotateAnimation
import com.georgcantor.kotlinsamples.R
import kotlinx.android.synthetic.main.activity_roulette.*
import java.util.*


class RouletteActivity : AppCompatActivity() {

    private val sectors = arrayOf("32 red", "15 black", "19 red", "4 black", "21 red",
            "2 black", "25 red", "17 black", "34 red", "6 black", "27 red", "13 black", "36 red",
            "11 black", "30 red", "8 black", "23 red", "10 black", "5 red", "24 black", "16 red",
            "33 black", "1 red", "20 black", "14 red", "31 black", "9 red", "22 black", "18 red",
            "29 black", "7 red", "28 black", "12 red", "35 black", "3 red", "26 black", "zero")

    private val random: Random = Random()
    private var degree: Int = 0
    private var degreeOld: Int = 0
    private val half_sector = 360f / 37f / 2f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_roulette)
    }

    fun spinClick(view: View) {
        degreeOld = degree % 360
        degree = random.nextInt(360) + 720

        val rotateAnim = RotateAnimation(degreeOld.toFloat(), degree.toFloat(),
                RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f)
        rotateAnim.duration = 3600
        rotateAnim.fillAfter = true
        rotateAnim.interpolator = DecelerateInterpolator()
        rotateAnim.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation) {
                resultTv.text = ""
            }

            override fun onAnimationEnd(animation: Animation) {
                resultTv.text = getSector(360 - degree % 360)
            }

            override fun onAnimationRepeat(animation: Animation) {
            }
        })

        wheel.startAnimation(rotateAnim)
    }

    private fun getSector(degrees: Int): String? {
        var i = 0
        var text: String? = null

        do {
            val start = half_sector * (i * 2 + 1)
            val end = half_sector * (i * 2 + 3)

            if (degrees >= start && degrees < end) {
                text = sectors[i]
            }

            i++

        } while (text == null && i < sectors.size)

        return text
    }
}
