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

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TimerDisplay(
    displayTime: String,
    digit: Int,
    countDownTime: CountDownTime,
    listener: OnCountDownTimeChangeListener
) {
    Column(modifier = Modifier.padding(top = 16.dp)) {
        val borderColor by animateColorAsState(
            targetValue = when (digit) {
                0 -> MaterialTheme.colors.primary
                1 -> Color(0xFFDD89DD)
                2 -> Color(0xFF673AB7)
                3 -> Color(0xFF3F51B5)
                4 -> Color(0xFF4CAF50)
                5 -> Color(0xFFFFEB3B)
                6 -> Color(0xFFFF9800)
                7 -> Color(0xFFF44336)
                8 -> Color(0xFF00BCD4)
                9 -> Color(0xFFFFC107)
                else -> Color(0xFF393044)
            },
        )

        Text(
            text = displayTime,
            style = MaterialTheme.typography.h2,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colors.primary,
            modifier = Modifier
                .padding(vertical = 36.dp, horizontal = 48.dp)
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
                .border(2.dp, borderColor, RoundedCornerShape(8.dp))
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
        colors = TextFieldDefaults.outlinedTextFieldColors(

        )
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
    TimerDisplay("01:30:00", 0, CountDownTime("2", "2", "2"), listener)
}
