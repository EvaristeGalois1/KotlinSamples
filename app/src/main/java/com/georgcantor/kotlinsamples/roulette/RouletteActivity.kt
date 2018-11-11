package com.georgcantor.kotlinsamples.roulette

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.georgcantor.kotlinsamples.R
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
}
