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

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.PlayArrow
import androidx.compose.material.icons.rounded.Stop
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TimerControl(
    callback: () -> Unit
) {

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        IconButton(
            onClick = { callback.invoke() },
            modifier = Modifier
                .padding(16.dp)
                .size(80.dp),
        ) {
            Icon(
                imageVector = Icons.Rounded.PlayArrow,
                contentDescription = "",
                tint = MaterialTheme.colors.surface,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(CircleShape)
                    .background(
                        color = MaterialTheme.colors.primaryVariant,
                        shape = MaterialTheme.shapes.large
                    )
            )
        }

        IconButton(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .padding(16.dp)
                .size(80.dp),
        ) {
            Icon(
                imageVector = Icons.Rounded.Stop,
                contentDescription = "",
                tint = MaterialTheme.colors.surface,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(CircleShape)
                    .background(
                        color = MaterialTheme.colors.primaryVariant,
                        shape = MaterialTheme.shapes.large
                    )
            )
        }
    }
}

@Preview
@Composable
fun TimerControlPreview() {
    TimerControl {}
}
