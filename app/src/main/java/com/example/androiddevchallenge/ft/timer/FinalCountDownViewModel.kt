/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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

    fun start(countDownTime: CountDownTime) {
        val milliseconds = with(countDownTime) {
            val h = hh.toIntOrNull() ?: 0
            val m = mm.toIntOrNull() ?: 0
            val s = ss.toIntOrNull() ?: 0
            (h * 3600 + m * 60 + s) * 1000L
        }

        timer = buildTimer(milliseconds)
        timer.start()
    }

    fun stop() {
        timer.cancel()
    }

    private fun buildTimer(milliseconds: Long): CountDownTimer {

        return object : CountDownTimer(milliseconds, 1000) {

            private val time = milliseconds

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
