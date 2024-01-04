package parsers

import com.tomaszz.parsers.parsers.CommaSeparatedParser
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Test
import kotlin.test.assertTrue

class CommaSeparatedParserTest {
    private val parser = CommaSeparatedParser(0, 60)

    @Test
    fun `isCommaSeparatedExpression test comma separated expression`() {
        assertTrue(parser.isParsable("1,2,5"))
        assertTrue(parser.isParsable("1"))
        assertTrue(parser.isParsable("5,44,777"))
    }

    @Test
    fun `isCommaSeparatedExpression test invalid expression`() {
        assertFalse(parser.isParsable(","))
        assertFalse(parser.isParsable("*"))
        assertFalse(parser.isParsable("1-2"))
        assertFalse(parser.isParsable("sdf"))
    }

    @Test
    fun `isCommaSeparatedExpression parse a valid string`() {
        val expected = listOf(1, 2, 3)
        assertEquals(expected, parser.parse("1,2,3"))
    }
}
