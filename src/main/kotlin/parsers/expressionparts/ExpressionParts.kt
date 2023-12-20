package com.tomaszz.parsers.expressionparts

import com.tomaszz.parsers.parsers.*

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
        private const val MINUTE_RANGE_MAX = 60
        private const val HOUR_RANGE_MAX = 24
        private const val DAY_OF_MONTH_MAX = 32
        private const val MONTH_MAX = 13
        private const val DAY_OF_WEEK_MAX = 8

        fun parse(input: String): CronExpression {
            val inputSplit = input.split(" ").also {
                if (it.size != 6) throw UnparsableExpressionException("Expected 6 parts, got ${it.size}.")
            }

            val minuteExpr = ExpressionPart.parse(inputSplit[0], 0, MINUTE_RANGE_MAX)
            val hourExpr = ExpressionPart.parse(inputSplit[1], 0, HOUR_RANGE_MAX)
            val dayOfMonth = ExpressionPart.parse(inputSplit[2], 1, DAY_OF_MONTH_MAX)
            val month = ExpressionPart.parse(inputSplit[3], 1, MONTH_MAX)
            val dayOfWeek = ExpressionPart.parse(inputSplit[4], 1, DAY_OF_WEEK_MAX)

            return CronExpression(minuteExpr, hourExpr, dayOfMonth, month, dayOfWeek, inputSplit[5])
        }
    }
}

data class ExpressionPart(val expression: String, val values: List<Int>) {
    companion object {
        fun parse(input: String, lowerBound: Int, upperBound: Int): ExpressionPart {
            if (isAsteriskExpression(input)) return ExpressionPart(input, parseAsterisk(input, lowerBound, upperBound))
            if (isCommaSeparatedExpression(input)) return ExpressionPart(input, parseCommaSeparated(input, lowerBound, upperBound))
            if (isRangeExpression(input)) return ExpressionPart(input, parseRange(input, lowerBound, upperBound))

            throw UnparsableExpressionException("Invalid input: $input")
        }
    }
}

class UnparsableExpressionException(message: String) : IllegalArgumentException(message)
