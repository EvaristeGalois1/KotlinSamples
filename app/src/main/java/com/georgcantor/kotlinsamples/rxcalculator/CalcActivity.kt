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

    fun click1(view: View) {
        et_field.text = SpannableStringBuilder("1")
        if (firstValue != 0) {
            secondValue = 1
        } else {
            firstValue = 1
        }
    }

    fun click2(view: View) {
        et_field.text = SpannableStringBuilder("2")
        if (firstValue != 0) {
            secondValue = 2
        } else {
            firstValue = 2
        }
    }

    fun click3(view: View) {
        et_field.text = SpannableStringBuilder("3")
        if (firstValue != 0) {
            secondValue = 3
        } else {
            firstValue = 3
        }
    }

    fun click4(view: View) {
        et_field.text = SpannableStringBuilder("4")
        if (firstValue != 0) {
            secondValue = 4
        } else {
            firstValue = 4
        }
    }

    fun click5(view: View) {
        et_field.text = SpannableStringBuilder("5")
        if (firstValue != 0) {
            secondValue = 5
        } else {
            firstValue = 5
        }
    }

    fun click6(view: View) {
        et_field.text = SpannableStringBuilder("6")
        if (firstValue != 0) {
            secondValue = 6
        } else {
            firstValue = 6
        }
    }

    fun click7(view: View) {
        et_field.text = SpannableStringBuilder("7")
        if (firstValue != 0) {
            secondValue = 7
        } else {
            firstValue = 7
        }
    }

    fun click8(view: View) {
        et_field.text = SpannableStringBuilder("8")
        if (firstValue != 0) {
            secondValue = 8
        } else {
            firstValue = 8
        }
    }

    fun click9(view: View) {
        et_field.text = SpannableStringBuilder("9")
        if (firstValue != 0) {
            secondValue = 9
        } else {
            firstValue = 9
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

    fun divideClick(view: View) {
        resultValue = firstValue / secondValue
    }

    fun equalsClick(view: View) {
        equals()
    }

    fun equals() {
        et_field.text = SpannableStringBuilder(resultValue.toString())
        firstValue = 0
        secondValue = 0
    }
}
