import ControlApp.ControlApp
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() {
    val server = SimpleWebSocketServer()
    server.start()

    application {
        Window(
            onCloseRequest = ::exitApplication,
            title = "Car Control Center",
        ) {
            ControlApp(server)
        }
    }

    println("WebSocket server started on ws://localhost:8090")
}