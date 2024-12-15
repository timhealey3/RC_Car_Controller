package websocket

enum class Status {
    START,
    CONTINUE,
    OFF
}

data class MessageScheme(
    var status: Status,
    var forward: String,
    var turn: String
)
