import org.junit.jupiter.api.Assertions.assertEquals
import kotlin.test.Test

class MainKtTest {
    private val server = SimpleWebSocketServer()

    @Test
    fun testWebsocket(){
        // test websocket opens correctly
        val expectedPost: Int = 8090
        assertEquals(expectedPost, server.port)
    }
}