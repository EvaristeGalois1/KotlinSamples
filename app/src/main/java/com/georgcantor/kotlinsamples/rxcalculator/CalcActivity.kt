package com.georgcantor.kotlinsamples.rxcalculator

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.SpannableStringBuilder
import android.view.View
import com.georgcantor.kotlinsamples.R
import kotlinx.android.synthetic.main.activity_calculator.*


class CalcActivity : AppCompatActivity() {

    private var firstValue: Int = 0
    private var secondValue: Int = 0
    private var resultValue: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)
    }

    fun clearClick(view: View) {
        et_field.text = SpannableStringBuilder("0")
        firstValue = 0
        secondValue = 0
    }

    fun click7(view: View) {
        et_field.text = SpannableStringBuilder("7")
        firstValue = 7
    }

    fun click5(view: View) {
        et_field.text = SpannableStringBuilder("5")
        secondValue = 5
        if (firstValue != 0) {
            firstValue = 5
        }
    }

    fun plusClick(view: View) {
        resultValue = firstValue.plus(secondValue)
    }

    fun minusClick(view: View) {
        resultValue = firstValue.minus(secondValue)
    }

    fun multipleClick(view: View) {
        resultValue = firstValue * secondValue
    }

    fun equalsClick(view: View) {
        equals()
    }

    fun equals() {
        et_field.text = SpannableStringBuilder(resultValue.toString())
    }
}
