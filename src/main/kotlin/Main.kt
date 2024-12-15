fun main() {
    val server = SimpleWebSocketServer()
    server.start()

    println("WebSocket server started on ws://localhost:8090")
}
