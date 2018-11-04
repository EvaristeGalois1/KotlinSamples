package com.georgcantor.kotlinsamples.rxcalculator

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.georgcantor.kotlinsamples.R
import java.math.BigDecimal
import java.text.DecimalFormat

class CalculatorActivity : AppCompatActivity() {

    private val formatter = object : DecimalFormat("#,###.#") {
        init {
            minimumFractionDigits = 0
            maximumFractionDigits = 8
        }
    }

    private val field = BigDecimal.ZERO
    private val stack = BigDecimal.ZERO
    private val currentFigure = Figure.NONE

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)
    }

    private enum class Figure {
        ADD,
        SUB,
        MULTI,
        DIV,
        NONE;

        private fun calculate(arg1: BigDecimal, arg2: BigDecimal): BigDecimal {

            return when (this) {
                ADD -> arg1.add(arg2)
                SUB -> arg1.subtract(arg2)
                MULTI -> arg1.multiply(arg2)
                DIV -> arg1.divide(arg2, 8, BigDecimal.ROUND_HALF_UP)
                else -> arg2
            }
        }
    }
}
