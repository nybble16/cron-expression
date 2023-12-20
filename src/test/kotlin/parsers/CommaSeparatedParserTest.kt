package parsers

import com.tomaszz.parsers.parsers.isCommaSeparatedExpression
import com.tomaszz.parsers.parsers.parseCommaSeparated
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Test
import kotlin.test.assertTrue

class CommaSeparatedParserTest {
    @Test
    fun `isCommaSeparatedExpression test comma separated expression`() {
        assertTrue(isCommaSeparatedExpression("1,2,5"))
        assertTrue(isCommaSeparatedExpression("1"))
        assertTrue(isCommaSeparatedExpression("5,44,777"))
    }

    @Test
    fun `isCommaSeparatedExpression test invalid expression`() {
        assertFalse(isCommaSeparatedExpression(","))
        assertFalse(isCommaSeparatedExpression("*"))
        assertFalse(isCommaSeparatedExpression("1-2"))
        assertFalse(isCommaSeparatedExpression("sdf"))
    }

    @Test
    fun `isCommaSeparatedExpression parse a valid string`() {
        val expected = listOf(1, 2, 3)
        assertEquals(expected, parseCommaSeparated("1,2,3", 0, 4))
    }
}
