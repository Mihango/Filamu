package com.techmashinani.filamu.utils


import android.content.Context
import android.widget.Toast

fun String.toast(context: Context, showLong: Boolean = true) {
    Toast.makeText(context, this, if(showLong) Toast.LENGTH_LONG else Toast.LENGTH_SHORT).show()
}