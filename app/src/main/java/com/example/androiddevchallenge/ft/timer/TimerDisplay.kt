package com.example.androiddevchallenge.ft.timer

import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TimerDisplay(time: String) {
    Text(
        text = time,
        style = MaterialTheme.typography.h6,
        modifier = Modifier.padding(16.dp)
    )
}

@Preview
@Composable
fun TimerDisplayPreview() {
    TimerDisplay("01:30:00")
}