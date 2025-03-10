package data_classes

data class TelemetryEntity(
    var on: Boolean,
    var forward: Int,
    var backward: Boolean,
    var left: Boolean,
    var right: Boolean,
    var throttle: Int,
)
