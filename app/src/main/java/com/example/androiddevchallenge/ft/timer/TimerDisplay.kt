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

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TimerDisplay(
    displayTime: String,
    countDownTime: CountDownTime,
    listener: OnCountDownTimeChangeListener
) {
    Column {
        Text(
            text = displayTime,
            style = MaterialTheme.typography.h1,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
        )

        Row(modifier = Modifier.align(alignment = Alignment.CenterHorizontally)) {

            TimerTextField(
                value = countDownTime.hh,
                onValueChange = { listener.onHoursChange(it) },
                label = "HH",
            )

            Text(
                text = ":",
                style = MaterialTheme.typography.h6,
                modifier = Modifier.padding(16.dp)
            )

            TimerTextField(
                value = countDownTime.mm,
                onValueChange = { listener.onMinutesChange(it) },
                label = "MM",
            )

            Text(
                text = ":",
                style = MaterialTheme.typography.h6,
                modifier = Modifier.padding(16.dp)
            )

            TimerTextField(
                value = countDownTime.ss,
                onValueChange = { listener.onSecondsChange(it) },
                label = "SS",
            )
        }
    }
}

@Composable
fun TimerTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String
) {
    OutlinedTextField(
        value = value,
        onValueChange = {
            if (it.length < 3) {
                onValueChange.invoke(it)
            }
        },
        label = { Text(label) },
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
        modifier = Modifier
            .wrapContentSize()
            .requiredWidth(80.dp)
            .clip(RoundedCornerShape(4.dp)),
    )
}

@Preview
@Composable
fun TimerTextFieldPreview() {
    TimerTextField("3", {}, "HH")
}

@Preview
@Composable
fun TimerDisplayPreview() {
    val listener = object : OnCountDownTimeChangeListener {
        override fun onHoursChange(hh: String) = Unit
        override fun onMinutesChange(mm: String) = Unit
        override fun onSecondsChange(ss: String) = Unit
    }
    TimerDisplay("01:30:00", CountDownTime("2", "2", "2"), listener)
}
