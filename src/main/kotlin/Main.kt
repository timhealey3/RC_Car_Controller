import ControllApp.Control
import ControllApp.DirectionStatus
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import javax.swing.border.TitledBorder

fun main() {
    val server = SimpleWebSocketServer()
    server.start()


    application {
        Window(onCloseRequest = ::exitApplication) {
            ControlApp(server)
        }
    }

    println("WebSocket server started on ws://localhost:8090")
}

@Composable
fun ControlApp(server: SimpleWebSocketServer) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text("Car Control Center")
        // TODO button to connect websocket ?
        // TODO button to close websocket ?
        Button(onClick = { Control.directionMessageBuilder(DirectionStatus.FORWARD, server) }) {
            Icon(
                imageVector = Icons.Default.KeyboardArrowUp,
                contentDescription = "Forward",
                modifier = Modifier.size(24.dp)
            )
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(onClick = { Control.directionMessageBuilder(DirectionStatus.LEFT, server) }) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowLeft,
                    contentDescription = "Left",
                    modifier = Modifier.size(24.dp)
                )
            }
            Button(onClick = { Control.directionMessageBuilder(DirectionStatus.BACKWARD, server) }) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowDown,
                    contentDescription = "Backward",
                    modifier = Modifier.size(24.dp)
                )
            }
            Button(onClick = { Control.directionMessageBuilder(DirectionStatus.RIGHT, server) }) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowRight,
                    contentDescription = "Right",
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    }
}