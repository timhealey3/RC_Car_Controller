package ControlApp.components

import SimpleWebSocketServer
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

fun convertThrottle(throttle: Int?) = (throttle ?: 0) * 25

@Composable
fun displayTeleData(server: SimpleWebSocketServer) {
    var throttle: Int = convertThrottle(server.teleEntity?.throttle)
    Text("Connected: ${if (server.teleEntity?.on == true) "True" else "False"}")
    Text("Throttle: $throttle%")
}
