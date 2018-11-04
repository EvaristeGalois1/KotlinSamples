package com.georgcantor.kotlinsamples.rxcalculator

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import com.georgcantor.kotlinsamples.R
import com.jakewharton.rxbinding.view.RxView
import io.reactivex.functions.Consumer
import kotlinx.android.synthetic.main.activity_calculator.*
import java.math.BigDecimal
import java.text.DecimalFormat

class CalculatorActivity : AppCompatActivity() {

    private val formatter = object : DecimalFormat("#,###.#") {
        init {
            minimumFractionDigits = 0
            maximumFractionDigits = 8
        }
    }

    private var field = BigDecimal.ZERO
    private var stack = BigDecimal.ZERO
    private var currentFigure = Figure.NONE

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        val numbers = arrayOf<Button>(button_0, button_1, button_2, button_3,
                button_4, button_5, button_6, button_7, button_8, button_9)
        for (button in numbers) {
            RxView.clicks(button).subscribe {
                (Consumer<Any> {
                    field = field.multiply(BigDecimal(10))
                            .add(BigDecimal(Integer.parseInt(button.tag.toString())))
                    et_field.setText(formatter.format(field))
                })
            }
        }

        val symbols = arrayOf<Button>(button_all_clear, button_add, button_sub,
                button_multi, button_divide)
        for (button in symbols) {
            RxView.clicks(button).subscribe {
                (Consumer<Any> {
                    currentFigure = Figure.valueOf(button.tag.toString())
                    stack = if (currentFigure !== Figure.NONE) field else BigDecimal.ZERO
                    field = BigDecimal.ZERO
                    if (stack == BigDecimal.ZERO) {
                        et_field.setText(formatter.format(field))
                    }
                })
            }
        }

        RxView.clicks(button_calc).subscribe {
            (Consumer<Any> {
                field = currentFigure.calculate(stack, field)
                et_field.setText(formatter.format(field))
            })
        }
    }

    private enum class Figure {
        ADD,
        SUB,
        MULTI,
        DIV,
        NONE;

        fun calculate(arg1: BigDecimal, arg2: BigDecimal): BigDecimal {

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
