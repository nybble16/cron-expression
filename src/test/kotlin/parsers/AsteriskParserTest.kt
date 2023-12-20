package parsers

import com.tomaszz.parsers.expressionparts.UnparsableExpressionException
import com.tomaszz.parsers.parsers.isAsteriskExpression
import com.tomaszz.parsers.parsers.parseAsterisk
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.assertThrows
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class AsteriskParserTest {
    @Test
    fun `isAsteriskExpression test simple asterisk`() {
        assertTrue(isAsteriskExpression("*"))
    }

    @Test
    fun `isAsteriskExpression test invalid asterisk`() {
        assertFalse(isAsteriskExpression("1-2"))
        assertFalse(isAsteriskExpression("5"))
        assertFalse(isAsteriskExpression("*/"))
        assertFalse(isAsteriskExpression("*/sdf"))
    }

    @Test
    fun `isAsteriskExpression test asterisk with increment`() {
        assertTrue(isAsteriskExpression("*/5"))
        assertTrue(isAsteriskExpression("*/1"))
        assertTrue(isAsteriskExpression("*/60"))
    }

    @Test
    fun `parseAsterisk test full range`() {
        val expected = (0 until 60).toList()
        assertEquals(expected, parseAsterisk("*", 0, 60))
    }

    @Test
    fun `parseAsterisk test small increment`() {
        val expected = listOf(0, 5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55)
        assertEquals(expected, parseAsterisk("*/5", 0, 60))
    }

    @Test
    fun `parseAsterisk test too large increment`() {
        val expected = listOf(0)
        assertEquals(expected, parseAsterisk("*/100", 0, 60))
    }

    @Test
    fun `parseAsterisk test throw exception for zero increment`() {
        assertThrows<UnparsableExpressionException> {
            parseAsterisk("*/0", 0, 60)
        }
    }
}
