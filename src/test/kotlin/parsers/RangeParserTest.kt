package parsers

import com.tomaszz.parsers.parsers.isRangeExpression
import com.tomaszz.parsers.parsers.parseRange
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class RangeParserTest {
    @Test
    fun `test valid range expression`() {
        assertTrue(isRangeExpression("1-2"))
    }

    @Test
    fun `test invalid range expression`() {
        assertFalse(isRangeExpression("1,5"))
        assertFalse(isRangeExpression("def"))
        assertFalse(isRangeExpression("10"))
        assertFalse(isRangeExpression("-"))
    }

    @Test
    fun `parse valid range string`() {
        val expected = listOf(1, 2, 3, 4, 5)
        assertEquals(expected, parseRange("1-5", 0, 6))
    }
}
