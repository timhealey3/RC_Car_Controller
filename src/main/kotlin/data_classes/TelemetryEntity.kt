package data_classes

data class TelemetryEntity(
    var on: Boolean,
    var forward: Boolean,
    var backward: Boolean,
    var right: Boolean,
    var left: Boolean,
    var throttle: Int,
)
