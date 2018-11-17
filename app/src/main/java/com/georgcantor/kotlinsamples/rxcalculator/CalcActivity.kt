package com.georgcantor.kotlinsamples.rxcalculator

import android.content.Intent
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
    private var isFirstClick0: Boolean = true

    private var isOperatorClick: Boolean = false
    private var resultIsEmpty: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)
    }

    fun clearClick(view: View) {
        restartActivity()
    }

    fun click1(view: View) {
        if (resultIsEmpty) {
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
        } else {
            firstValue = resultValue
            if (isFirstClick2) {
                et_field.text = SpannableStringBuilder("2")
                secondValue = 2
                isFirstClick2 = false
            } else {
                val value: String = (secondValue.toString() + "2")
                et_field.text = SpannableStringBuilder(value)
                secondValue = Integer.parseInt(value)
            }
        }
    }

    fun click2(view: View) {
        if (resultIsEmpty) {
            if (!isOperatorClick) {
                if (isFirstClick2) {
                    et_field.text = SpannableStringBuilder("2")
                    firstValue = 2
                    isFirstClick2 = false
                } else {
                    val value: String = (firstValue.toString() + "2")
                    et_field.text = SpannableStringBuilder(value)
                    firstValue = Integer.parseInt(value)
                }
            } else {
                if (isFirstClick2) {
                    et_field.text = SpannableStringBuilder("2")
                    secondValue = 2
                    isFirstClick2 = false
                } else {
                    val value: String = (secondValue.toString() + "2")
                    et_field.text = SpannableStringBuilder(value)
                    secondValue = Integer.parseInt(value)
                }
            }
        } else {
            firstValue = resultValue
            if (isFirstClick2) {
                et_field.text = SpannableStringBuilder("2")
                secondValue = 2
                isFirstClick2 = false
            } else {
                val value: String = (secondValue.toString() + "2")
                et_field.text = SpannableStringBuilder(value)
                secondValue = Integer.parseInt(value)
            }
        }
    }

    fun click3(view: View) {
        if (resultIsEmpty) {
            if (!isOperatorClick) {
                if (isFirstClick3) {
                    et_field.text = SpannableStringBuilder("3")
                    firstValue = 3
                    isFirstClick3 = false
                } else {
                    val value: String = (firstValue.toString() + "3")
                    et_field.text = SpannableStringBuilder(value)
                    firstValue = Integer.parseInt(value)
                }
            } else {
                if (isFirstClick3) {
                    et_field.text = SpannableStringBuilder("3")
                    secondValue = 3
                    isFirstClick3 = false
                } else {
                    val value: String = (secondValue.toString() + "3")
                    et_field.text = SpannableStringBuilder(value)
                    secondValue = Integer.parseInt(value)
                }
            }
        } else {
            firstValue = resultValue
            if (isFirstClick3) {
                et_field.text = SpannableStringBuilder("3")
                secondValue = 3
                isFirstClick3 = false
            } else {
                val value: String = (secondValue.toString() + "3")
                et_field.text = SpannableStringBuilder(value)
                secondValue = Integer.parseInt(value)
            }
        }
    }

    fun click4(view: View) {
        if (resultIsEmpty) {
            if (!isOperatorClick) {
                if (isFirstClick4) {
                    et_field.text = SpannableStringBuilder("4")
                    firstValue = 4
                    isFirstClick4 = false
                } else {
                    val value: String = (firstValue.toString() + "4")
                    et_field.text = SpannableStringBuilder(value)
                    firstValue = Integer.parseInt(value)
                }
            } else {
                if (isFirstClick4) {
                    et_field.text = SpannableStringBuilder("4")
                    secondValue = 4
                    isFirstClick4 = false
                } else {
                    val value: String = (secondValue.toString() + "4")
                    et_field.text = SpannableStringBuilder(value)
                    secondValue = Integer.parseInt(value)
                }
            }
        } else {
            firstValue = resultValue
            if (isFirstClick4) {
                et_field.text = SpannableStringBuilder("4")
                secondValue = 4
                isFirstClick4 = false
            } else {
                val value: String = (secondValue.toString() + "4")
                et_field.text = SpannableStringBuilder(value)
                secondValue = Integer.parseInt(value)
            }
        }
    }

    fun click5(view: View) {
        if (resultIsEmpty) {
            if (!isOperatorClick) {
                if (isFirstClick5) {
                    et_field.text = SpannableStringBuilder("5")
                    firstValue = 5
                    isFirstClick5 = false
                } else {
                    val value: String = (firstValue.toString() + "5")
                    et_field.text = SpannableStringBuilder(value)
                    firstValue = Integer.parseInt(value)
                }
            } else {
                if (isFirstClick5) {
                    et_field.text = SpannableStringBuilder("5")
                    secondValue = 5
                    isFirstClick5 = false
                } else {
                    val value: String = (secondValue.toString() + "5")
                    et_field.text = SpannableStringBuilder(value)
                    secondValue = Integer.parseInt(value)
                }
            }
        } else {
            firstValue = resultValue
            if (isFirstClick5) {
                et_field.text = SpannableStringBuilder("5")
                secondValue = 5
                isFirstClick5 = false
            } else {
                val value: String = (secondValue.toString() + "5")
                et_field.text = SpannableStringBuilder(value)
                secondValue = Integer.parseInt(value)
            }
        }
    }

    fun click6(view: View) {
        if (resultIsEmpty) {
            if (!isOperatorClick) {
                if (isFirstClick6) {
                    et_field.text = SpannableStringBuilder("6")
                    firstValue = 6
                    isFirstClick6 = false
                } else {
                    val value: String = (firstValue.toString() + "6")
                    et_field.text = SpannableStringBuilder(value)
                    firstValue = Integer.parseInt(value)
                }
            } else {
                if (isFirstClick6) {
                    et_field.text = SpannableStringBuilder("6")
                    secondValue = 6
                    isFirstClick6 = false
                } else {
                    val value: String = (secondValue.toString() + "6")
                    et_field.text = SpannableStringBuilder(value)
                    secondValue = Integer.parseInt(value)
                }
            }
        } else {
            firstValue = resultValue
            if (isFirstClick6) {
                et_field.text = SpannableStringBuilder("6")
                secondValue = 6
                isFirstClick6 = false
            } else {
                val value: String = (secondValue.toString() + "6")
                et_field.text = SpannableStringBuilder(value)
                secondValue = Integer.parseInt(value)
            }
        }
    }

    fun click7(view: View) {
        if (resultIsEmpty) {
            if (!isOperatorClick) {
                if (isFirstClick7) {
                    et_field.text = SpannableStringBuilder("7")
                    firstValue = 7
                    isFirstClick7 = false
                } else {
                    val value: String = (firstValue.toString() + "7")
                    et_field.text = SpannableStringBuilder(value)
                    firstValue = Integer.parseInt(value)
                }
            } else {
                if (isFirstClick7) {
                    et_field.text = SpannableStringBuilder("7")
                    secondValue = 7
                    isFirstClick7 = false
                } else {
                    val value: String = (secondValue.toString() + "7")
                    et_field.text = SpannableStringBuilder(value)
                    secondValue = Integer.parseInt(value)
                }
            }
        } else {
            firstValue = resultValue
            if (isFirstClick7) {
                et_field.text = SpannableStringBuilder("7")
                secondValue = 7
                isFirstClick7 = false
            } else {
                val value: String = (secondValue.toString() + "7")
                et_field.text = SpannableStringBuilder(value)
                secondValue = Integer.parseInt(value)
            }
        }
    }

    fun click8(view: View) {
        if (resultIsEmpty) {
            if (!isOperatorClick) {
                if (isFirstClick8) {
                    et_field.text = SpannableStringBuilder("8")
                    firstValue = 8
                    isFirstClick8 = false
                } else {
                    val value: String = (firstValue.toString() + "8")
                    et_field.text = SpannableStringBuilder(value)
                    firstValue = Integer.parseInt(value)
                }
            } else {
                if (isFirstClick8) {
                    et_field.text = SpannableStringBuilder("8")
                    secondValue = 8
                    isFirstClick8 = false
                } else {
                    val value: String = (secondValue.toString() + "8")
                    et_field.text = SpannableStringBuilder(value)
                    secondValue = Integer.parseInt(value)
                }
            }
        } else {
            firstValue = resultValue
            if (isFirstClick8) {
                et_field.text = SpannableStringBuilder("8")
                secondValue = 8
                isFirstClick8 = false
            } else {
                val value: String = (secondValue.toString() + "8")
                et_field.text = SpannableStringBuilder(value)
                secondValue = Integer.parseInt(value)
            }
        }
    }

    fun click9(view: View) {
        if (resultIsEmpty) {
            if (!isOperatorClick) {
                if (isFirstClick9) {
                    et_field.text = SpannableStringBuilder("9")
                    firstValue = 9
                    isFirstClick9 = false
                } else {
                    val value: String = (firstValue.toString() + "9")
                    et_field.text = SpannableStringBuilder(value)
                    firstValue = Integer.parseInt(value)
                }
            } else {
                if (isFirstClick9) {
                    et_field.text = SpannableStringBuilder("9")
                    secondValue = 9
                    isFirstClick9 = false
                } else {
                    val value: String = (secondValue.toString() + "9")
                    et_field.text = SpannableStringBuilder(value)
                    secondValue = Integer.parseInt(value)
                }
            }
        } else {
            firstValue = resultValue
            if (isFirstClick9) {
                et_field.text = SpannableStringBuilder("9")
                secondValue = 9
                isFirstClick9 = false
            } else {
                val value: String = (secondValue.toString() + "9")
                et_field.text = SpannableStringBuilder(value)
                secondValue = Integer.parseInt(value)
            }
        }
    }

    fun click0(view: View) {
        if (resultIsEmpty) {
            if (!isOperatorClick) {
                if (isFirstClick0) {
                    et_field.text = SpannableStringBuilder("0")
                    firstValue = 0
                    isFirstClick0 = false
                } else {
                    val value: String = (firstValue.toString() + "0")
                    et_field.text = SpannableStringBuilder(value)
                    firstValue = Integer.parseInt(value)
                }
            } else {
                if (isFirstClick0) {
                    et_field.text = SpannableStringBuilder("0")
                    secondValue = 0
                    isFirstClick0 = false
                } else {
                    val value: String = (secondValue.toString() + "0")
                    et_field.text = SpannableStringBuilder(value)
                    secondValue = Integer.parseInt(value)
                }
            }
        } else {
            firstValue = resultValue
            if (isFirstClick0) {
                et_field.text = SpannableStringBuilder("0")
                secondValue = 0
                isFirstClick0 = false
            } else {
                val value: String = (secondValue.toString() + "0")
                et_field.text = SpannableStringBuilder(value)
                secondValue = Integer.parseInt(value)
            }
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

        isFirstClick1 = true
        isFirstClick2 = true
        isFirstClick3 = true
        isFirstClick4 = true
        isFirstClick5 = true
        isFirstClick6 = true
        isFirstClick7 = true
        isFirstClick8 = true
        isFirstClick9 = true
        isFirstClick0 = true

        isOperatorClick = false
        resultIsEmpty = false
    }

    private fun restartActivity() {
        val intent = (Intent(this@CalcActivity, CalcActivity::class.java))
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }
}
