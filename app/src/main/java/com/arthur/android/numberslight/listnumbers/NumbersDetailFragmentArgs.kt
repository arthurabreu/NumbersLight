package com.arthur.android.numberslight.listnumbers

import androidx.fragment.app.Fragment

const val NUMBERS = "numbers"

fun Fragment.getNumber() = arguments?.getInt(NUMBERS)