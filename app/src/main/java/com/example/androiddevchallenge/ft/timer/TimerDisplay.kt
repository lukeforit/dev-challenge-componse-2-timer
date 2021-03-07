package com.example.androiddevchallenge.ft.timer

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.getValue
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TimerDisplay(time: String) {
    Column {
        Text(
            text = time,
            style = MaterialTheme.typography.h1,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
        )

        Row(modifier = Modifier.align(alignment = Alignment.CenterHorizontally)) {
            var textH by remember { mutableStateOf("") }

            TextField(
                value = textH,
                onValueChange = { textH = it },
                label = { Text("HH") },
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                modifier = Modifier
                    .size(80.dp)
                    .wrapContentHeight(),
            )

            Text(
                text = ":",
                style = MaterialTheme.typography.h6,
                modifier = Modifier.padding(16.dp)
            )

            var textM by remember { mutableStateOf("") }

            TextField(
                value = textM,
                onValueChange = { textM = it },
                label = { Text("MM") },
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                modifier = Modifier
                    .size(80.dp)
                    .wrapContentHeight(),
            )

            Text(
                text = ":",
                style = MaterialTheme.typography.h6,
                modifier = Modifier.padding(16.dp)
            )
            var textS by remember { mutableStateOf("") }

            TextField(
                value = textS,
                onValueChange = { textS = it },
                label = { Text("SS") },
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                modifier = Modifier
                    .size(80.dp)
                    .wrapContentHeight(),
            )
        }
    }
}

@Preview
@Composable
fun TimerDisplayPreview() {
    TimerDisplay("01:30:00")
}