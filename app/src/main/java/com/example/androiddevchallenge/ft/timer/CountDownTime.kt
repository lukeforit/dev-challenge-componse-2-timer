package com.example.androiddevchallenge.ft.timer

data class CountDownTime(
    val hh: String,
    val mm: String,
    val ss: String,
)

interface OnCountDownTimeChangeListener {
    fun onHoursChange(hh: String)
    fun onMinutesChange(mm: String)
    fun onSecondsChange(ss: String)
}