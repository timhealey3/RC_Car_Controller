package ControlApp

import SimpleWebSocketServer
import data_classes.*

class Control {
    companion object {
        fun directionMessageBuilder(direction: InputStatus, server: SimpleWebSocketServer) {
            val message: MessageScheme = when (direction) {
                InputStatus.LEFT -> MessageScheme(CarStatus.NONE, ForwardStatus.NONE, TurnStatus.LEFT)
                InputStatus.RIGHT -> MessageScheme(CarStatus.NONE, ForwardStatus.NONE, TurnStatus.RIGHT)
                InputStatus.FORWARD -> MessageScheme(CarStatus.NONE, ForwardStatus.FORWARD, TurnStatus.NONE)
                InputStatus.BACKWARD -> MessageScheme(CarStatus.NONE, ForwardStatus.BACKWARD, TurnStatus.NONE)
                InputStatus.STRAIGHTEN -> MessageScheme(CarStatus.NONE, ForwardStatus.NONE, TurnStatus.STRAIGHTEN)
                InputStatus.OFF -> MessageScheme(CarStatus.OFF, ForwardStatus.NONE, TurnStatus.NONE)
                InputStatus.AUTO -> MessageScheme(CarStatus.AUTO, ForwardStatus.NONE, TurnStatus.NONE)
                InputStatus.MANUAL -> MessageScheme(CarStatus.MANUAL, ForwardStatus.NONE, TurnStatus.NONE)
                InputStatus.TRAINING -> MessageScheme(CarStatus.TRAINING, ForwardStatus.NONE, TurnStatus.NONE)
                InputStatus.NONE -> MessageScheme(CarStatus.NONE, ForwardStatus.NONE, TurnStatus.NONE)
            }
            server.sendMessage(message)
        }
    }
}
