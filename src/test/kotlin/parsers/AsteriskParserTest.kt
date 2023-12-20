package parsers

import com.tomaszz.parsers.parsers.isAsteriskExpression
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class AsteriskParserTest {
    @Test
    fun testIsAsteriskExpression_positive() {
        val input = "*"
        val expected = true
        val actual = isAsteriskExpression(input)
        assertEquals(expected, actual, "The isCommaSeparatedExpression function did not return the expected boolean.")
    }

    @Test
    fun testIsAsteriskExpression_negative() {
        val input = "1-2"
        val expected = false
        val actual = isAsteriskExpression(input)
        assertEquals(expected, actual, "The isCommaSeparatedExpression function did not return the expected boolean.")
    }
}
