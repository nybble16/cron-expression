package parsers

import com.tomaszz.parsers.expressionparts.UnparsableExpressionException
import com.tomaszz.parsers.parsers.AsteriskParser
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.assertThrows
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class AsteriskParserTest {
    private val parser = AsteriskParser(0, 60)

    @Test
    fun `isAsteriskExpression test simple asterisk`() {
        assertTrue(parser.isParsable("*"))
        assertTrue(parser.isParsable("*/15"))
        assertFalse(parser.isParsable("5"))
        assertFalse(parser.isParsable("1-5"))
    }

    @Test
    fun `isAsteriskExpression test invalid asterisk`() {
        assertFalse(parser.isParsable("1-2"))
        assertFalse(parser.isParsable("5"))
        assertFalse(parser.isParsable("*/"))
        assertFalse(parser.isParsable("*/sdf"))
    }

    @Test
    fun `isAsteriskExpression test asterisk with increment`() {
        assertTrue(parser.isParsable("*/5"))
        assertTrue(parser.isParsable("*/1"))
        assertTrue(parser.isParsable("*/60"))
    }

    @Test
    fun `parseAsterisk test full range`() {
        val expected = (0 until 60).toList()
        assertEquals(expected, parser.parse("*"))
    }

    @Test
    fun `parseAsterisk test small increment`() {
        val expected = listOf(0, 5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55)
        assertEquals(expected, parser.parse("*/5"))
    }

    @Test
    fun `parseAsterisk test too large increment`() {
        val expected = listOf(0)
        assertEquals(expected, parser.parse("*/100"))
    }

    @Test
    fun `parseAsterisk test throw exception for zero increment`() {
        assertThrows<UnparsableExpressionException> {
            parser.parse("*/0")
        }
    }
}
