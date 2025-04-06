package ControlApp.components

import ControlApp.Control
import SimpleWebSocketServer
import androidx.compose.foundation.gestures.awaitEachGesture
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.waitForUpOrCancellation
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import data_classes.InputStatus

fun sendDirectionalData(server: SimpleWebSocketServer, inputStatus: InputStatus) {
    Control.directionMessageBuilder(inputStatus, server)
}

fun sendDataStraighten(server: SimpleWebSocketServer) {
    Control.directionMessageBuilder(InputStatus.STRAIGHTEN, server)
}

@Composable
fun customButton(server: SimpleWebSocketServer, inputStatus: InputStatus, icon: ImageVector, displayText: String) {
    Button(
        onClick = {
        },
        modifier = Modifier.pointerInput(Unit) {
            awaitEachGesture {
                val initialDown = awaitFirstDown(requireUnconsumed = false)
                if (initialDown.pressed) {
                    sendDirectionalData(server, inputStatus)
                }
                waitForUpOrCancellation()
                if (inputStatus == InputStatus.RIGHT || inputStatus == InputStatus.LEFT) {
                    sendDataStraighten(server)
                }
            }
        }) {
        Icon(
            imageVector = icon,
            contentDescription = displayText,
            modifier = Modifier.size(24.dp)
        )
    }
}