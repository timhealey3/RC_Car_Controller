package ControlApp

import ControlApp.components.customButton
import ControlApp.components.offButton
import ControlApp.components.trainingButton
import data_classes.InputStatus
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
            offButton(server, "Off")
            trainingButton(server)
        }
        // control buttons
        customButton(server, InputStatus.FORWARD, Icons.Default.KeyboardArrowUp, "Forward")
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            customButton(server, InputStatus.LEFT, Icons.Default.KeyboardArrowLeft, "Left")
            customButton(server, InputStatus.BACKWARD, Icons.Default.KeyboardArrowDown, "Backward")
            customButton(server, InputStatus.RIGHT, Icons.Default.KeyboardArrowRight, "Right")
        }
    }
}