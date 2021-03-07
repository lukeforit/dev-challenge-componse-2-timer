package com.example.androiddevchallenge.ft.timer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.PlayCircleOutline
import androidx.compose.material.icons.outlined.Stop
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TimerControl() {

    Row {
        IconButton(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .padding(16.dp)
                .wrapContentSize(Alignment.Center),
        ) {
            Icon(
                imageVector = Icons.Outlined.PlayCircleOutline,
                contentDescription = "",
                tint = MaterialTheme.colors.secondary,
                modifier = Modifier
                    .wrapContentSize()
                    .clip(CircleShape)
                    .background(
                        color = MaterialTheme.colors.primaryVariant,
                        shape = MaterialTheme.shapes.medium
                    )
            )
        }

        IconButton(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .padding(16.dp)
                .wrapContentSize(Alignment.Center),
        ) {
            Icon(
                imageVector = Icons.Outlined.Stop,
                contentDescription = "",
                tint = MaterialTheme.colors.secondary,
                modifier = Modifier
                    .wrapContentSize()
                    .clip(CircleShape)
                    .background(
                        color = MaterialTheme.colors.primaryVariant,
                        shape = MaterialTheme.shapes.medium
                    )
            )
        }

    }
}


@Preview
@Composable
fun TimerControlPreview() {
    TimerControl()
}