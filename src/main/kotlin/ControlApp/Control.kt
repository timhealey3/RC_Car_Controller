package ControlApp

import SimpleWebSocketServer
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

import websocket.*

enum class InputStatus {
    LEFT,
    RIGHT,
    FORWARD,
    BACKWARD,
    OFF,
    AUTO,
    MANUAL,
    TRAINING,
    NONE
}

class Control {
    companion object {
        fun directionMessageBuilder(direction: InputStatus, server: SimpleWebSocketServer) {
            val message: MessageScheme = when (direction) {
                InputStatus.LEFT -> MessageScheme(CarStatus.NONE, ForwardStatus.NONE, TurnStatus.LEFT)
                InputStatus.RIGHT -> MessageScheme(CarStatus.NONE, ForwardStatus.NONE, TurnStatus.RIGHT)
                InputStatus.FORWARD -> MessageScheme(CarStatus.NONE, ForwardStatus.FORWARD, TurnStatus.NONE)
                InputStatus.BACKWARD -> MessageScheme(CarStatus.NONE, ForwardStatus.BACKWARD, TurnStatus.LEFT)
                InputStatus.OFF -> MessageScheme(CarStatus.OFF, ForwardStatus.NONE, TurnStatus.NONE)
                InputStatus.AUTO -> MessageScheme(CarStatus.AUTO, ForwardStatus.NONE, TurnStatus.NONE)
                InputStatus.MANUAL -> MessageScheme(CarStatus.MANUAL, ForwardStatus.NONE, TurnStatus.NONE)
                InputStatus.TRAINING -> MessageScheme(CarStatus.TRAINING, ForwardStatus.NONE, TurnStatus.NONE)
                InputStatus.NONE -> MessageScheme(CarStatus.NONE, ForwardStatus.NONE, TurnStatus.NONE)
            }
            server.sendMessage(message)
        }

        @Composable
        fun setColor(direction: InputStatus, selected: Boolean): Color {
            var color: Color = Color.LightGray
            if (selected) {
                color = when (direction) {
                InputStatus.LEFT -> Color.Blue
                InputStatus.RIGHT -> Color.Blue
                InputStatus.FORWARD -> Color.Blue
                InputStatus.BACKWARD -> Color.Blue
                InputStatus.OFF -> Color.Red
                InputStatus.AUTO -> Color.Red
                InputStatus.MANUAL -> Color.Red
                InputStatus.TRAINING -> Color.Red
                InputStatus.NONE -> Color.Red
            }
            }
            return color
        }
    }
}