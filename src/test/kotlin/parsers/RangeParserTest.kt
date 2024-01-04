package parsers

import com.tomaszz.parsers.parsers.RangeParser
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class RangeParserTest {
    private val parser = RangeParser(1, 8)

    @Test
    fun `test valid range expression`() {
        assertTrue(parser.isParsable("1-2"))
    }

    @Test
    fun `test invalid range expression`() {
        assertFalse(parser.isParsable("1,5"))
        assertFalse(parser.isParsable("def"))
        assertFalse(parser.isParsable("10"))
        assertFalse(parser.isParsable("-"))
    }

    @Test
    fun `parse valid range string`() {
        val expected = listOf(1, 2, 3, 4, 5)
        assertEquals(expected, parser.parse("1-5"))
    }
}
