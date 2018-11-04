package com.georgcantor.kotlinsamples.algorithms

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.georgcantor.kotlinsamples.R
import kotlinx.android.synthetic.main.activity_fibonacci.*
import java.util.*


class FibonacciActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fibonacci)

        getFibonacciNumbers(22)
    }

    private fun getFibonacciNumbers(number: Int) {
        var one = 0
        var two = 1

        val result = IntArray(number)
        result[0] = one
        result[1] = two
        for (i in 2 until number) {
            result[i] = two + one
            one = two
            two = result[i]
        }

        textViewFibonacci.text = Arrays.toString(result)
    }
}
