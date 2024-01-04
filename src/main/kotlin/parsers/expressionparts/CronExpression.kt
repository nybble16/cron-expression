package com.tomaszz.parsers.expressionparts

import com.tomaszz.parsers.parsers.ParserFactory.getDayOfWeekParser
import com.tomaszz.parsers.parsers.ParserFactory.getDayParser
import com.tomaszz.parsers.parsers.ParserFactory.getHourParser
import com.tomaszz.parsers.parsers.ParserFactory.getMinuteParser
import com.tomaszz.parsers.parsers.ParserFactory.getMonthParser

data class CronExpression(val minute: ExpressionPart, val hour: ExpressionPart, val dayOfMonth: ExpressionPart, val month: ExpressionPart, val dayOfWeek: ExpressionPart, val command: String) {

    override fun toString(): String {
        return """
            minute        ${minute.values.joinToString(" ")}
            hour          ${hour.values.joinToString(" ")}
            day of month  ${dayOfMonth.values.joinToString(" ")}
            month         ${month.values.joinToString(" ")}
            day of week   ${dayOfWeek.values.joinToString(" ")}
            command       $command
        """.trimIndent()
    }

    companion object {
        fun parse(input: String): CronExpression {
            val inputSplit = input.split(" ").also {
                if (it.size != 6) throw UnparsableExpressionException("Expected 6 parts, got ${it.size}.")
            }

            val minuteExpr = getMinuteParser().parse(inputSplit[0])
            val hourExpr = getHourParser().parse(inputSplit[1])
            val dayOfMonth = getDayParser().parse(inputSplit[2])
            val month = getMonthParser().parse(inputSplit[3])
            val dayOfWeek = getDayOfWeekParser().parse(inputSplit[4])

            return CronExpression(minuteExpr, hourExpr, dayOfMonth, month, dayOfWeek, inputSplit[5])
        }
    }
}
