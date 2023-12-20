package expressionparts

import com.tomaszz.parsers.expressionparts.CronExpression
import com.tomaszz.parsers.expressionparts.ExpressionPart
import org.junit.jupiter.api.Assertions.assertEquals
import kotlin.test.Test

class ExpressionPartsTest {
    @Test
    fun testParse() {
        val input = "*/15 0 1,15 * 1-5 /usr/bin/find"
        val expected = CronExpression(
                minute = ExpressionPart.parse("*/15", 0, 60),
                hour = ExpressionPart.parse("0", 0, 24),
                dayOfMonth = ExpressionPart.parse("1,15", 1, 32),
                month = ExpressionPart.parse("*", 1, 13),
                dayOfWeek = ExpressionPart.parse("1-5", 1, 8),
                command = "/usr/bin/find"
        )
        val actual = CronExpression.parse(input)
        assertEquals(expected, actual, "The parse function did not return the expected CronExpression.")
    }

    @Test
    fun testToString() {
        val input = "*/15 0 1,15 * 1-5 /usr/bin/find"
        val cronExpression = CronExpression.parse(input)
        val expected = """
            minute        0 15 30 45
            hour          0
            day of month  1 15
            month         1 2 3 4 5 6 7 8 9 10 11 12
            day of week   1 2 3 4 5
            command       /usr/bin/find
        """.trimIndent()
        val actual = cronExpression.toString()
    }
}
