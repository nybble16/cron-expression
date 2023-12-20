package parsers

import com.tomaszz.parsers.parsers.isRangeExpression
import com.tomaszz.parsers.parsers.parseRange
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RangeParserTest {
    @Test
    fun testIsRangeExpression_positive() {
        val input = "1-2"
        val expected = true
        val actual = isRangeExpression(input)
        assertEquals(expected, actual, "The isRangeExpression function did not return the expected boolean.")
    }

    @Test
    fun testIsRangeExpression_negative() {
        val input = "-1-2"
        val expected = false
        val actual = isRangeExpression(input)
        assertEquals(expected, actual, "The isRangeExpression function did not return the expected boolean.")
    }

    @Test
    fun testParseRange() {
        val input = "1-2"
        val lowerBound = 1
        val upperBound = 3
        val expected = listOf(1, 2)
        val actual = parseRange(input, lowerBound, upperBound)
        assertEquals(expected, actual, "The parseRange function did not return the expected list.")
    }
}
