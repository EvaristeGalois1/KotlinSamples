package com.georgcantor.kotlinsamples.rxcalculator

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.SpannableStringBuilder
import android.view.View
import android.widget.Toast
import com.georgcantor.kotlinsamples.R
import kotlinx.android.synthetic.main.activity_calculator.*
import java.text.DecimalFormat

class CalcActivity : AppCompatActivity() {

    private val dFormat: DecimalFormat = DecimalFormat("###.#")

    private var firstValue: Double = 0.toDouble()
    private var secondValue: Double = 0.toDouble()
    private var resultValue: Double = 0.toDouble()
    private var typeOfOperator: Int = 0

    private var isFirstClick: Boolean = true
    private var isOperatorClick: Boolean = false
    private var resultIsEmpty: Boolean = true
    private var isCalcFinished: Boolean = false
    private var isDotClicked: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        val value = intent.getStringExtra("digit") ?: return
        if (!value.isEmpty()) {
            isFirstClick = false
            val digit: Int = Integer.parseInt(value)
            firstValue = digit.toDouble()
            et_field.text = SpannableStringBuilder(digit.toString())
        }
    }

    fun click1(view: View) {
        if (isCalcFinished && !isOperatorClick) {
            restartAndSend("1")
        } else {
            if (resultIsEmpty) {
                if (!isOperatorClick) {
                    if (isFirstClick) {
                        et_field.text = SpannableStringBuilder("1")
                        firstValue = 1.0
                        isFirstClick = false
                    } else {
                        if (isDotClicked) {
                            val value: String = ((dFormat.format(firstValue)).toString() + ".1")
                            et_field.text = SpannableStringBuilder(value)
                            firstValue = (value).toDouble()
                            isDotClicked = false
                        } else {
                            val value: String = ((dFormat.format(firstValue)).toString() + "1")
                            et_field.text = SpannableStringBuilder(value)
                            firstValue = (value).toDouble()
                        }
                    }
                } else {
                    if (isFirstClick) {
                        et_field.text = SpannableStringBuilder("1")
                        secondValue = 1.0
                        isFirstClick = false
                    } else {
                        if (isDotClicked) {
                            val value: String = ((dFormat.format(firstValue)).toString() + ".1")
                            et_field.text = SpannableStringBuilder(value)
                            firstValue = (value).toDouble()
                            isDotClicked = false
                        } else {
                            val value: String = ((dFormat.format(firstValue)).toString() + "1")
                            et_field.text = SpannableStringBuilder(value)
                            firstValue = (value).toDouble()
                        }
                    }
                }
            } else {
                firstValue = resultValue
                if (isFirstClick) {
                    et_field.text = SpannableStringBuilder("1")
                    secondValue = 1.0
                    isFirstClick = false
                } else {
                    if (isDotClicked) {
                        val value: String = ((dFormat.format(secondValue)).toString() + ".1")
                        et_field.text = SpannableStringBuilder(value)
                        secondValue = (value).toDouble()
                        isDotClicked = false
                    } else {
                        val value: String = ((dFormat.format(secondValue)).toString() + "1")
                        et_field.text = SpannableStringBuilder(value)
                        secondValue = (value).toDouble()
                    }
                }
            }
        }
    }

    fun click2(view: View) {
        if (isCalcFinished && !isOperatorClick) {
            restartAndSend("2")
        } else {
            if (resultIsEmpty) {
                if (!isOperatorClick) {
                    if (isFirstClick) {
                        et_field.text = SpannableStringBuilder("2")
                        firstValue = 2.0
                        isFirstClick = false
                    } else {
                        if (isDotClicked) {
                            val value: String = ((dFormat.format(firstValue)).toString() + ".2")
                            et_field.text = SpannableStringBuilder(value)
                            firstValue = (value).toDouble()
                            isDotClicked = false
                        } else {
                            val value: String = ((dFormat.format(firstValue)).toString() + "2")
                            et_field.text = SpannableStringBuilder(value)
                            firstValue = (value).toDouble()
                        }
                    }
                } else {
                    if (isFirstClick) {
                        et_field.text = SpannableStringBuilder("2")
                        secondValue = 2.0   
                        isFirstClick = false
                    } else {
                        if (isDotClicked) {
                            val value: String = ((dFormat.format(firstValue)).toString() + ".2")
                            et_field.text = SpannableStringBuilder(value)
                            firstValue = (value).toDouble()
                            isDotClicked = false
                        } else {
                            val value: String = ((dFormat.format(firstValue)).toString() + "2")
                            et_field.text = SpannableStringBuilder(value)
                            firstValue = (value).toDouble()
                        }
                    }
                }
            } else {
                firstValue = resultValue
                if (isFirstClick) {
                    et_field.text = SpannableStringBuilder("2")
                    secondValue = 2.0
                    isFirstClick = false
                } else {
                    if (isDotClicked) {
                        val value: String = ((dFormat.format(secondValue)).toString() + ".2")
                        et_field.text = SpannableStringBuilder(value)
                        secondValue = (value).toDouble()
                        isDotClicked = false
                    } else {
                        val value: String = ((dFormat.format(secondValue)).toString() + "2")
                        et_field.text = SpannableStringBuilder(value)
                        secondValue = (value).toDouble()
                    }
                }
            }
        }
    }

    fun click3(view: View) {
        if (isCalcFinished && !isOperatorClick) {
            restartAndSend("3")
        } else {
            if (resultIsEmpty) {
                if (!isOperatorClick) {
                    if (isFirstClick) {
                        et_field.text = SpannableStringBuilder("3")
                        firstValue = 3.0
                        isFirstClick = false
                    } else {
                        val value: String = ((dFormat.format(firstValue)).toString() + "3")
                        et_field.text = SpannableStringBuilder(value)
                        firstValue = (value).toDouble()
                    }
                } else {
                    if (isFirstClick) {
                        et_field.text = SpannableStringBuilder("3")
                        secondValue = 3.0
                        isFirstClick = false
                    } else {
                        val value: String = ((dFormat.format(secondValue)).toString() + "3")
                        et_field.text = SpannableStringBuilder(value)
                        secondValue = (value).toDouble()
                    }
                }
            } else {
                firstValue = resultValue
                if (isFirstClick) {
                    et_field.text = SpannableStringBuilder("3")
                    secondValue = 3.0
                    isFirstClick = false
                } else {
                    val value: String = ((dFormat.format(secondValue)).toString() + "3")
                    et_field.text = SpannableStringBuilder(value)
                    secondValue = (value).toDouble()
                }
            }
        }
    }

    fun click4(view: View) {
        if (isCalcFinished && !isOperatorClick) {
            restartAndSend("4")
        } else {
            if (resultIsEmpty) {
                if (!isOperatorClick) {
                    if (isFirstClick) {
                        et_field.text = SpannableStringBuilder("4")
                        firstValue = 4.0
                        isFirstClick = false
                    } else {
                        val value: String = ((dFormat.format(firstValue)).toString() + "4")
                        et_field.text = SpannableStringBuilder(value)
                        firstValue = (value).toDouble()
                    }
                } else {
                    if (isFirstClick) {
                        et_field.text = SpannableStringBuilder("4")
                        secondValue = 4.0
                        isFirstClick = false
                    } else {
                        val value: String = ((dFormat.format(secondValue)).toString() + "4")
                        et_field.text = SpannableStringBuilder(value)
                        secondValue = (value).toDouble()
                    }
                }
            } else {
                firstValue = resultValue
                if (isFirstClick) {
                    et_field.text = SpannableStringBuilder("4")
                    secondValue = 4.0
                    isFirstClick = false
                } else {
                    val value: String = ((dFormat.format(secondValue)).toString() + "4")
                    et_field.text = SpannableStringBuilder(value)
                    secondValue = (value).toDouble()
                }
            }
        }
    }

    fun click5(view: View) {
        if (isCalcFinished && !isOperatorClick) {
            restartAndSend("5")
        } else {
            if (resultIsEmpty) {
                if (!isOperatorClick) {
                    if (isFirstClick) {
                        et_field.text = SpannableStringBuilder("5")
                        firstValue = 5.0
                        isFirstClick = false
                    } else {
                        val value: String = ((dFormat.format(firstValue)).toString() + "5")
                        et_field.text = SpannableStringBuilder(value)
                        firstValue = (value).toDouble()
                    }
                } else {
                    if (isFirstClick) {
                        et_field.text = SpannableStringBuilder("5")
                        secondValue = 5.0
                        isFirstClick = false
                    } else {
                        val value: String = ((dFormat.format(secondValue)).toString() + "5")
                        et_field.text = SpannableStringBuilder(value)
                        secondValue = (value).toDouble()
                    }
                }
            } else {
                firstValue = resultValue
                if (isFirstClick) {
                    et_field.text = SpannableStringBuilder("5")
                    secondValue = 5.0
                    isFirstClick = false
                } else {
                    val value: String = ((dFormat.format(secondValue)).toString() + "5")
                    et_field.text = SpannableStringBuilder(value)
                    secondValue = (value).toDouble()
                }
            }
        }
    }

//    fun click6(view: View) {
//        if (isCalcFinished && !isOperatorClick) {
//            restartAndSend("6")
//        } else {
//            if (resultIsEmpty) {
//                if (!isOperatorClick) {
//                    if (isFirstClick) {
//                        et_field.text = SpannableStringBuilder("6")
//                        firstValue = 6
//                        isFirstClick = false
//                    } else {
//                        val value: String = (firstValue.toString() + "6")
//                        et_field.text = SpannableStringBuilder(value)
//                        firstValue = Integer.parseInt(value)
//                    }
//                } else {
//                    if (isFirstClick) {
//                        et_field.text = SpannableStringBuilder("6")
//                        secondValue = 6
//                        isFirstClick = false
//                    } else {
//                        val value: String = (secondValue.toString() + "6")
//                        et_field.text = SpannableStringBuilder(value)
//                        secondValue = Integer.parseInt(value)
//                    }
//                }
//            } else {
//                firstValue = resultValue
//                if (isFirstClick) {
//                    et_field.text = SpannableStringBuilder("6")
//                    secondValue = 6
//                    isFirstClick = false
//                } else {
//                    val value: String = (secondValue.toString() + "6")
//                    et_field.text = SpannableStringBuilder(value)
//                    secondValue = Integer.parseInt(value)
//                }
//            }
//        }
//    }
//
//    fun click7(view: View) {
//        if (isCalcFinished && !isOperatorClick) {
//            restartAndSend("7")
//        } else {
//            if (resultIsEmpty) {
//                if (!isOperatorClick) {
//                    if (isFirstClick) {
//                        et_field.text = SpannableStringBuilder("7")
//                        firstValue = 7
//                        isFirstClick = false
//                    } else {
//                        val value: String = (firstValue.toString() + "7")
//                        et_field.text = SpannableStringBuilder(value)
//                        firstValue = Integer.parseInt(value)
//                    }
//                } else {
//                    if (isFirstClick) {
//                        et_field.text = SpannableStringBuilder("7")
//                        secondValue = 7
//                        isFirstClick = false
//                    } else {
//                        val value: String = (secondValue.toString() + "7")
//                        et_field.text = SpannableStringBuilder(value)
//                        secondValue = Integer.parseInt(value)
//                    }
//                }
//            } else {
//                firstValue = resultValue
//                if (isFirstClick) {
//                    et_field.text = SpannableStringBuilder("7")
//                    secondValue = 7
//                    isFirstClick = false
//                } else {
//                    val value: String = (secondValue.toString() + "7")
//                    et_field.text = SpannableStringBuilder(value)
//                    secondValue = Integer.parseInt(value)
//                }
//            }
//        }
//    }
//
//    fun click8(view: View) {
//        if (isCalcFinished && !isOperatorClick) {
//            restartAndSend("8")
//        } else {
//            if (resultIsEmpty) {
//                if (!isOperatorClick) {
//                    if (isFirstClick) {
//                        et_field.text = SpannableStringBuilder("8")
//                        firstValue = 8
//                        isFirstClick = false
//                    } else {
//                        val value: String = (firstValue.toString() + "8")
//                        et_field.text = SpannableStringBuilder(value)
//                        firstValue = Integer.parseInt(value)
//                    }
//                } else {
//                    if (isFirstClick) {
//                        et_field.text = SpannableStringBuilder("8")
//                        secondValue = 8
//                        isFirstClick = false
//                    } else {
//                        val value: String = (secondValue.toString() + "8")
//                        et_field.text = SpannableStringBuilder(value)
//                        secondValue = Integer.parseInt(value)
//                    }
//                }
//            } else {
//                firstValue = resultValue
//                if (isFirstClick) {
//                    et_field.text = SpannableStringBuilder("8")
//                    secondValue = 8
//                    isFirstClick = false
//                } else {
//                    val value: String = (secondValue.toString() + "8")
//                    et_field.text = SpannableStringBuilder(value)
//                    secondValue = Integer.parseInt(value)
//                }
//            }
//        }
//    }
//
//    fun click9(view: View) {
//        if (isCalcFinished && !isOperatorClick) {
//            restartAndSend("9")
//        } else {
//            if (resultIsEmpty) {
//                if (!isOperatorClick) {
//                    if (isFirstClick) {
//                        et_field.text = SpannableStringBuilder("9")
//                        firstValue = 9
//                        isFirstClick = false
//                    } else {
//                        val value: String = (firstValue.toString() + "9")
//                        et_field.text = SpannableStringBuilder(value)
//                        firstValue = Integer.parseInt(value)
//                    }
//                } else {
//                    if (isFirstClick) {
//                        et_field.text = SpannableStringBuilder("9")
//                        secondValue = 9
//                        isFirstClick = false
//                    } else {
//                        val value: String = (secondValue.toString() + "9")
//                        et_field.text = SpannableStringBuilder(value)
//                        secondValue = Integer.parseInt(value)
//                    }
//                }
//            } else {
//                firstValue = resultValue
//                if (isFirstClick) {
//                    et_field.text = SpannableStringBuilder("9")
//                    secondValue = 9
//                    isFirstClick = false
//                } else {
//                    val value: String = (secondValue.toString() + "9")
//                    et_field.text = SpannableStringBuilder(value)
//                    secondValue = Integer.parseInt(value)
//                }
//            }
//        }
//    }
//
//    fun click0(view: View) {
//        if (isCalcFinished && !isOperatorClick) {
//            restartAndSend("0")
//        } else {
//            if (resultIsEmpty) {
//                if (!isOperatorClick) {
//                    if (isFirstClick) {
//                        et_field.text = SpannableStringBuilder("0")
//                        firstValue = 0
//                        isFirstClick = false
//                    } else {
//                        val value: String = (firstValue.toString() + "0")
//                        et_field.text = SpannableStringBuilder(value)
//                        firstValue = Integer.parseInt(value)
//                    }
//                } else {
//                    if (isFirstClick) {
//                        et_field.text = SpannableStringBuilder("0")
//                        secondValue = 0
//                        isFirstClick = false
//                    } else {
//                        val value: String = (secondValue.toString() + "0")
//                        et_field.text = SpannableStringBuilder(value)
//                        secondValue = Integer.parseInt(value)
//                    }
//                }
//            } else {
//                firstValue = resultValue
//                if (isFirstClick) {
//                    et_field.text = SpannableStringBuilder("0")
//                    secondValue = 0
//                    isFirstClick = false
//                } else {
//                    val value: String = (secondValue.toString() + "0")
//                    et_field.text = SpannableStringBuilder(value)
//                    secondValue = Integer.parseInt(value)
//                }
//            }
//        }
//    }

    fun plusClick(view: View) {
        isOperatorClick = true
        Toast.makeText(this, "isOperatorClick", Toast.LENGTH_SHORT).show()
        typeOfOperator = 1
    }

    fun minusClick(view: View) {
        isOperatorClick = true
        Toast.makeText(this, "isOperatorClick", Toast.LENGTH_SHORT).show()
        typeOfOperator = 2
    }

    fun multipleClick(view: View) {
        isOperatorClick = true
        Toast.makeText(this, "isOperatorClick", Toast.LENGTH_SHORT).show()
        typeOfOperator = 3
    }

    fun divideClick(view: View) {
        isOperatorClick = true
        Toast.makeText(this, "isOperatorClick", Toast.LENGTH_SHORT).show()
        typeOfOperator = 4
    }

    fun dotClick(view: View) {
        isDotClicked = true
    }

    fun clearClick(view: View) {
//        et_field.text = SpannableStringBuilder("0")
//        firstValue = 0
//        secondValue = 0
//        resultValue = 0
//
//        isFirstClick = true
//        isOperatorClick = false
//        resultIsEmpty = false
        restartActivity()
    }

    private fun restartActivity() {
        val intent = (Intent(this@CalcActivity, CalcActivity::class.java))
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }

    private fun restartAndSend(value: String) {
        val intent = (Intent(this@CalcActivity, CalcActivity::class.java))
        intent.putExtra("digit", value)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }

    fun equalsClick(view: View) {
        isOperatorClick = false
        equals()
    }

    fun equals() {
        try {
            when (typeOfOperator) {
                1 -> resultValue = firstValue.plus(secondValue)
                2 -> resultValue = firstValue.minus(secondValue)
                3 -> resultValue = firstValue * secondValue
                4 -> resultValue = firstValue / secondValue
            }

            if (isPrime(resultValue.toInt())) {
                et_field.text = SpannableStringBuilder(dFormat.format(resultValue).toString())
            } else {
                et_field.text = SpannableStringBuilder(resultValue.toString())
            }
            firstValue = 0.0
            secondValue = 0.0

            isFirstClick = true
            isOperatorClick = false
            resultIsEmpty = false
            isCalcFinished = true
        } catch (e: ArithmeticException) {
            e.printStackTrace()
        }
    }

    private fun isPrime(number: Int): Boolean {
        return number % 1 == 0
    }
}
