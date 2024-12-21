package ControlApp

import SimpleWebSocketServer
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun ControlApp(server: SimpleWebSocketServer) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        // top row set up buttons
        Text("Car Control Center")
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            offButton(server)
            trainingButton(server)
        }
        // control buttons
        Button(onClick = { Control.directionMessageBuilder(InputStatus.FORWARD, server) }) {
            Icon(
                imageVector = Icons.Default.KeyboardArrowUp,
                contentDescription = "Forward",
                modifier = Modifier.size(24.dp)
            )
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(onClick = { Control.directionMessageBuilder(InputStatus.LEFT, server) }) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowLeft,
                    contentDescription = "Left",
                    modifier = Modifier.size(24.dp)
                )
            }
            Button(onClick = { Control.directionMessageBuilder(InputStatus.BACKWARD, server) }) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowDown,
                    contentDescription = "Backward",
                    modifier = Modifier.size(24.dp)
                )
            }
            Button(onClick = { Control.directionMessageBuilder(InputStatus.RIGHT, server) }) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowRight,
                    contentDescription = "Right",
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    }
}

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
            backgroundColor = Control.setColor(InputStatus.TRAINING, trainingSelected)
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
            backgroundColor = Control.setColor(InputStatus.MANUAL, manualSelected)
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
            backgroundColor = Control.setColor(InputStatus.AUTO, autoSelected)
        )
    ) {
        Text("Autonomous")
    }
}

@Composable
fun offButton(server: SimpleWebSocketServer) {
    var offSelected by remember { mutableStateOf(false) }

    Button(
        onClick = {
            offSelected = !offSelected
            Control.directionMessageBuilder(InputStatus.OFF, server)
        },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Control.setColor(InputStatus.OFF, offSelected)
        )
    ) {
        Text("OFF")
    }
}