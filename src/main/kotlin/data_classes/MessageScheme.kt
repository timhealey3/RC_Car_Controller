package data_classes

data class MessageScheme(
    var status: CarStatus,
    var forward: ForwardStatus,
    var turn: TurnStatus
)
