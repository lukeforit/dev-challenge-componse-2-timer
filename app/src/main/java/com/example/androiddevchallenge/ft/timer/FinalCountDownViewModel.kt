package com.example.androiddevchallenge.ft.timer

import android.os.CountDownTimer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FinalCountDownViewModel : ViewModel() {

    private val _timeLiveData: MutableLiveData<String> = MutableLiveData()
    val timeLiveData: LiveData<String> get() = _timeLiveData

    private var timer = buildTimer(0)

    init {
        _timeLiveData.value = "00:00:00"
    }

    fun start(miliseconds: Long) {
        timer = buildTimer(miliseconds)
        timer.start()
    }

    fun stop() {
        timer.cancel()
    }

    private fun buildTimer(miliseconds: Long): CountDownTimer {

        return object : CountDownTimer(miliseconds, 1000) {

            private val time = miliseconds

            override fun onTick(millisUntilFinished: Long) {
                val seconds = millisUntilFinished / 1000
                val s = seconds % 60
                val m = (seconds / 60) % 60
                val h = (seconds / (60 * 60)) % 24
                _timeLiveData.value = String.format("%02d:%02d:%02d", h, m, s)
            }

            override fun onFinish() {}

        }
    }
}