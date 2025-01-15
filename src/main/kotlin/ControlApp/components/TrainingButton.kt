package ControlApp.components

import ControlApp.Control
import SimpleWebSocketServer
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import data_classes.InputStatus

@Composable
fun trainingButton(server: SimpleWebSocketServer) {
    var trainingSelected by remember { mutableStateOf(false) }
    var manualSelected by remember { mutableStateOf(false) }
    var autoSelected by remember { mutableStateOf(false) }

    Button(
        onClick = {
            trainingSelected = !trainingSelected
            manualSelected = false
            autoSelected = false
            Control.directionMessageBuilder(InputStatus.TRAINING, server)
        },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = ColorSelector(InputStatus.TRAINING, trainingSelected)
        )
    ) {
        Text("Training")
    }
    Button(
        onClick = {
            manualSelected = !manualSelected
            autoSelected = false
            trainingSelected = false
            Control.directionMessageBuilder(InputStatus.MANUAL, server)
        },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = ColorSelector(InputStatus.MANUAL, manualSelected)
        )
    ) {
        Text("Manual")
    }
    Button(
        onClick = {
            autoSelected = !autoSelected
            manualSelected = false
            trainingSelected = false
            Control.directionMessageBuilder(InputStatus.AUTO, server)
        },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = ColorSelector(InputStatus.AUTO, autoSelected)
        )
    ) {
        Text("Autonomous")
    }
}