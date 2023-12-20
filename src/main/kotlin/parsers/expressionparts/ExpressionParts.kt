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
        fun parse(input: String): CronExpression {
            val inputSplit = input.split(" ", limit = 6)
            val minuteExpr = ExpressionPart.parse(inputSplit[0], 0, 60)
            val hourExpr = ExpressionPart.parse(inputSplit[1], 0, 24)
            val dayOfMonth = ExpressionPart.parse(inputSplit[2], 1, 32)
            val month = ExpressionPart.parse(inputSplit[3], 1, 13)
            val dayOfWeek = ExpressionPart.parse(inputSplit[4], 1, 8)
            return CronExpression(minuteExpr, hourExpr, dayOfMonth, month, dayOfWeek, inputSplit[5])
        }
    }
}

data class ExpressionPart(val expression: String, val values: List<Int>) {
    companion object {
        fun parse(input: String, lowerBound: Int, upperBound: Int): ExpressionPart {
            if (isAsteriskExpression(input)) return ExpressionPart(input, parseAsterisk(input, lowerBound, upperBound))
            if (isCommaSeparatedExpression(input)) return ExpressionPart(input, parseCommaSeparated(input))
            if (isRangeExpression(input)) return ExpressionPart(input, parseRange(input, lowerBound, upperBound))

            throw UnparsableExpressionException("Invalid input: $input")
        }
    }
}

class UnparsableExpressionException(message: String) : Exception(message)
