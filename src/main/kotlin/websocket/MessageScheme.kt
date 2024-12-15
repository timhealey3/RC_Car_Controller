package websocket

enum class CarStatus {
    START,
    OFF,
    NONE
}

enum class ForwardStatus {
    FORWARD,
    BACKWARD,
    NONE
}

enum class TurnStatus {
    LEFT,
    RIGHT,
    NONE
}

data class MessageScheme(
    var status: CarStatus,
    var forward: ForwardStatus,
    var turn: TurnStatus
)
