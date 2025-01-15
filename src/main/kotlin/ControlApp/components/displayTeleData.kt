package ControlApp.components

import SimpleWebSocketServer
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun displayTeleData(server: SimpleWebSocketServer) {
    Text("Connected: ${server.teleEntity?.on ?: "False"}")
    Text("Throttle: ${server.teleEntity?.throttle ?: 0}%")
}
