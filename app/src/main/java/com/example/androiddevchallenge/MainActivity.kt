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
package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import com.example.androiddevchallenge.ft.timer.CountDownTime
import com.example.androiddevchallenge.ft.timer.FinalCountDownViewModel
import com.example.androiddevchallenge.ft.timer.OnCountDownTimeChangeListener
import com.example.androiddevchallenge.ft.timer.TimerControl
import com.example.androiddevchallenge.ft.timer.TimerDisplay
import com.example.androiddevchallenge.ui.theme.MyTheme

class MainActivity : AppCompatActivity() {

    private val viewModel: FinalCountDownViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            MyTheme {
                window.statusBarColor = MaterialTheme.colors.surface.toArgb()
                window.navigationBarColor = MaterialTheme.colors.surface.toArgb()

                MyApp(viewModel)
            }
        }
    }
}

// Start building your app here!
@Composable
fun MyApp(viewModel: FinalCountDownViewModel) {
    Surface(color = MaterialTheme.colors.background, modifier = Modifier.fillMaxSize()) {
        Column() {
            val time: String by viewModel.timeLiveData.observeAsState("")
            val digit: Int by viewModel.animationLiveData.observeAsState(0)

            var textH by remember { mutableStateOf("") }
            var textM by remember { mutableStateOf("") }
            var textS by remember { mutableStateOf("") }

            val countDownTime = CountDownTime(textH, textM, textS)

            TimerDisplay(
                displayTime = time,
                digit = digit,
                countDownTime,
                object : OnCountDownTimeChangeListener {
                    override fun onHoursChange(hh: String) {
                        textH = hh
                    }

                    override fun onMinutesChange(mm: String) {
                        textM = mm
                    }

                    override fun onSecondsChange(ss: String) {
                        textS = ss
                    }
                }
            )

            TimerControl {
                viewModel.start(countDownTime)
            }
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        MyApp(FinalCountDownViewModel())
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        MyApp(FinalCountDownViewModel())
    }
}
