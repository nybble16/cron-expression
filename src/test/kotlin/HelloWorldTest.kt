import com.tomaszz.helloWorld
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class HelloWorldTest {

    @Test
    fun testHelloWorld() {
        val expected = "Hello, World!"
        val actual = helloWorld()
        assertEquals(expected, actual, "The helloWorld function did not return the expected string.")
    }
}
