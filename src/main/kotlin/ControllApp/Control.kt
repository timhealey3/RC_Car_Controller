package ControllApp

import SimpleWebSocketServer
import websocket.*

enum class DirectionStatus {
    LEFT,
    RIGHT,
    FORWARD,
    BACKWARD,
    NONE
}

class Control {
    companion object {
        fun directionMessageBuilder(direction: DirectionStatus, server: SimpleWebSocketServer) {
            val message: MessageScheme = when (direction) {
                DirectionStatus.LEFT -> MessageScheme(CarStatus.NONE, ForwardStatus.NONE, TurnStatus.LEFT)
                DirectionStatus.RIGHT -> MessageScheme(CarStatus.NONE, ForwardStatus.NONE, TurnStatus.RIGHT)
                DirectionStatus.FORWARD -> MessageScheme(CarStatus.NONE, ForwardStatus.FORWARD, TurnStatus.NONE)
                DirectionStatus.BACKWARD -> MessageScheme(CarStatus.NONE, ForwardStatus.BACKWARD, TurnStatus.LEFT)
                DirectionStatus.NONE -> MessageScheme(CarStatus.NONE, ForwardStatus.NONE, TurnStatus.NONE)
            }
            server.sendMessage(message)
        }
    }
}