import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import data_classes.*
import org.java_websocket.WebSocket
import org.java_websocket.handshake.ClientHandshake
import org.java_websocket.server.WebSocketServer
import java.net.InetSocketAddress


class SimpleWebSocketServer : WebSocketServer(InetSocketAddress(8090)) {
    private val gson = Gson()
    private var message = MessageScheme(CarStatus.OFF, ForwardStatus.NONE, TurnStatus.NONE)
    var teleEntity by mutableStateOf<TelemetryEntity?>(null)
    // This is called when a client connects to the server
    override fun onOpen(conn: WebSocket?, handshake: ClientHandshake?) {
        println("Client connected: ${conn?.remoteSocketAddress}")
        // start car
        message.status = CarStatus.START
        val jsonMessage = gson.toJson(message)
        conn?.send(jsonMessage)
    }

    override fun onMessage(conn: WebSocket?, message: String?) {
        println("Received message: $message")
        try {
            teleEntity = gson.fromJson(message, TelemetryEntity::class.java)
            println("Received telemetry data: $teleEntity")
        } catch (e: Exception) {
            println("Could not be converted to telemetry data: $message")
            e.printStackTrace()
        }
    }

    override fun onClose(conn: WebSocket?, code: Int, reason: String?, remote: Boolean) {
        println("Client disconnected: $reason")
    }

    override fun onError(conn: WebSocket?, ex: Exception?) {
        println("Error occurred: ${ex?.message}")
    }

    override fun onStart() {
        println("WebSocket server started!")
    }

    fun sendMessage(message: MessageScheme) {
        println("Sent Status=${message.status} Forward=${message.forward} turn=${message.turn}")
        connections.forEach { connection ->
            if (connection.isOpen) {
                val jsonMessage = gson.toJson(message)
                connection.send(jsonMessage)
            }
        }
    }
}
