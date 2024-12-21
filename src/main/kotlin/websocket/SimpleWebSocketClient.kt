import org.java_websocket.WebSocket
import org.java_websocket.handshake.ClientHandshake
import org.java_websocket.server.WebSocketServer
import java.net.InetSocketAddress
import com.google.gson.Gson
import websocket.*

class SimpleWebSocketServer : WebSocketServer(InetSocketAddress(8090)) {
    private val gson = Gson()
    private var message = MessageScheme(CarStatus.OFF, ForwardStatus.NONE, TurnStatus.NONE)

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
        println("Sent Status=${message.status} Forward=${message.forward} Message=${message.turn}")
        connections.forEach { connection ->
            if (connection.isOpen) {
                message.status = CarStatus.NONE
                message.forward = ForwardStatus.FORWARD
                message.turn = TurnStatus.LEFT
                val jsonMessage = gson.toJson(message)
                connection.send(jsonMessage)
            }
        }
    }
}