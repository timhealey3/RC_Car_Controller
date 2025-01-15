package ControlApp.components

import ControlApp.Control
import SimpleWebSocketServer
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import data_classes.InputStatus

@Composable
fun customButton(server: SimpleWebSocketServer, inputStatus: InputStatus, icon: ImageVector, displayText: String) {
    Button(onClick = { Control.directionMessageBuilder(inputStatus, server) }) {
        Icon(
            imageVector = icon,
            contentDescription = displayText,
            modifier = Modifier.size(24.dp)
        )
    }
}