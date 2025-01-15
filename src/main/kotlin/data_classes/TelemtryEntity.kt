package data_classes

data class TelemetryEntity(
    val on: Boolean,
    val forward: Boolean,
    val backward: Boolean,
    val left: Boolean,
    val right: Boolean,
    val throttle: Int,
)