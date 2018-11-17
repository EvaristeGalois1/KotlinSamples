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

    private var typeOfOperator: Int = 0

    private var isFirstClick1: Boolean = true
    private var isFirstClick2: Boolean = true
    private var isFirstClick3: Boolean = true
    private var isFirstClick4: Boolean = true
    private var isFirstClick5: Boolean = true
    private var isFirstClick6: Boolean = true
    private var isFirstClick7: Boolean = true
    private var isFirstClick8: Boolean = true
    private var isFirstClick9: Boolean = true

    private var isOperatorClick: Boolean = false

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
        if (!isOperatorClick) {
            if (isFirstClick1) {
                et_field.text = SpannableStringBuilder("1")
                firstValue = 1
                isFirstClick1 = false
            } else {
                val value: String = (firstValue.toString() + "1")
                et_field.text = SpannableStringBuilder(value)
                firstValue = Integer.parseInt(value)
            }
        } else {
            if (isFirstClick1) {
                et_field.text = SpannableStringBuilder("1")
                secondValue = 1
                isFirstClick1 = false
            } else {
                val value: String = (secondValue.toString() + "1")
                et_field.text = SpannableStringBuilder(value)
                secondValue = Integer.parseInt(value)
            }
        }
    }

    fun click2(view: View) {
        if (isFirstClick2) {
            et_field.text = SpannableStringBuilder("2")
            firstValue = 1
            isFirstClick2 = false
        } else {
            val value: String = (firstValue.toString() + "2")
            et_field.text = SpannableStringBuilder(value)
            secondValue = Integer.parseInt(value)
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
        isOperatorClick = true
        typeOfOperator = 1
    }

    fun minusClick(view: View) {
        isOperatorClick = true
        typeOfOperator = 2
    }

    fun multipleClick(view: View) {
        isOperatorClick = true
        typeOfOperator = 3
    }

    fun divideClick(view: View) {
        isOperatorClick = true
        typeOfOperator = 4
    }

    fun equalsClick(view: View) {
        isOperatorClick = false
        equals()
    }

    fun equals() {
        when (typeOfOperator) {
            1 -> resultValue = firstValue.plus(secondValue)
            2 -> resultValue = firstValue.minus(secondValue)
            3 -> resultValue = firstValue * secondValue
            4 -> resultValue = firstValue / secondValue
        }

        et_field.text = SpannableStringBuilder(resultValue.toString())
        firstValue = 0
        secondValue = 0
    }
}
