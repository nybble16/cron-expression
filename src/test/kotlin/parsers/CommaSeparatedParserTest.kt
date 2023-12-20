package parsers

import com.tomaszz.parsers.parsers.isCommaSeparatedExpression
import com.tomaszz.parsers.parsers.parseCommaSeparated
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CommaSeparatedParserTest {
    @Test
    fun testIsCommaSeparatedExpression_positive() {
        val input = "1,2,5"
        val expected = true
        val actual = isCommaSeparatedExpression(input)
        assertEquals(expected, actual, "The isCommaSeparatedExpression function did not return the expected boolean.")
    }

    @Test
    fun testIsCommaSeparatedExpression_negative() {
        val input = "1-2"
        val expected = false
        val actual = isCommaSeparatedExpression(input)
        assertEquals(expected, actual, "The isCommaSeparatedExpression function did not return the expected boolean.")
    }

    @Test
    fun testParseCommaSeparated() {
        val input = "1,2,5"
        val expected = listOf(1, 2, 5)
        val actual = parseCommaSeparated(input, 0, 6)
        assertEquals(expected, actual, "The parseCommaSeparated function did not return the expected list.")
    }
}
