import org.junit.jupiter.api.Assertions.assertEquals
import org.mockito.Mock
import kotlin.test.Test

class MainKtTest {
    @Mock
    private val server = SimpleWebSocketServer()

    @Test
    fun testWebsocket(){
        // test websocket opens correctly
        val expectedPost = 8090
        assertEquals(expectedPost, server.port)
    }
}