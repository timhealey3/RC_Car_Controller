import org.java_websocket.WebSocket
import org.java_websocket.handshake.ClientHandshake
import org.java_websocket.server.WebSocketServer
import websocket.MessageScheme
import java.net.InetSocketAddress
import kotlin.concurrent.timer
import com.google.gson.Gson
import websocket.Status

class SimpleWebSocketServer : WebSocketServer(InetSocketAddress(8090)) {
    private val gson = Gson()
    private var message = MessageScheme(Status.OFF, "", "")

    // This is called when a client connects to the server
    override fun onOpen(conn: WebSocket?, handshake: ClientHandshake?) {
        println("Client connected: ${conn?.remoteSocketAddress}")

        // start car
        message.status = Status.START
        val jsonMessageTwo = gson.toJson(message)
        conn?.send(jsonMessageTwo)

        startSendingMessages()
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

    // Send messages to all connected clients at regular intervals
    private fun startSendingMessages() {
        println("message attempted")
        // Timer that sends a message every 5 seconds (5000 ms)
        timer(period = 5000) {
            // Send a message to all connected clients
            connections.forEach { conn ->
                if (conn.isOpen) {
                    message.status = Status.CONTINUE
                    message.forward = "w"
                    message.turn = "s"
                    val jsonMessage = gson.toJson(message)
                    conn.send(jsonMessage)
                }
            }
        }
    }
}