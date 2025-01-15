package ControlApp.components

import ControlApp.Control
import data_classes.InputStatus
import SimpleWebSocketServer
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*

@Composable
fun offButton(server: SimpleWebSocketServer, displayString: String) {
    var offSelected by remember { mutableStateOf(false) }

    Button(
        onClick = {
            offSelected = !offSelected
            Control.directionMessageBuilder(InputStatus.OFF, server)
        },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = ColorSelector(InputStatus.OFF, offSelected)
        )
    ) {
        Text(displayString)
    }
}