package com.tomaszz.parsers.expressionparts

import com.tomaszz.parsers.parsers.*

data class CronExpression(val minute: MinuteExpression, val hour: HourExpression, val dayOfMonth: DayOfMonthExpression, val month: MonthExpression, val dayOfWeek: DayOfWeekExpression, val command: String) {

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
            val minuteExpr = MinuteExpression.parse(inputSplit[0])
            val hourExpr = HourExpression.parse(inputSplit[1])
            val dayOfMonth = DayOfMonthExpression.parse(inputSplit[2])
            val month = MonthExpression.parse(inputSplit[3])
            val dayOfWeek = DayOfWeekExpression.parse(inputSplit[4])
            return CronExpression(minuteExpr, hourExpr, dayOfMonth, month, dayOfWeek, inputSplit[5])
        }
    }
}

data class MinuteExpression(val expression: String, val values: List<Int>) {
    companion object {
        fun parse(input: String): MinuteExpression {
            if (isAsteriskExpression(input)) return MinuteExpression(input, parseAsterisk(input, 0, 60))
            if (isCommaSeparatedExpression(input)) return MinuteExpression(input, parseCommaSeparated(input))
            if (isRangeExpression(input)) return MinuteExpression(input, parseRange(input, 0, 60))

            throw UnparsableExpressionException("Invalid input: $input")
        }
    }
}

data class HourExpression(val expression: String, val values: List<Int>) {
    companion object {
        fun parse(input: String): HourExpression {
            if (isAsteriskExpression(input)) return HourExpression(input, parseAsterisk(input, 0, 24))
            if (isCommaSeparatedExpression(input)) return HourExpression(input, parseCommaSeparated(input))
            if (isRangeExpression(input)) return HourExpression(input, parseRange(input, 0, 24))

            throw UnparsableExpressionException("Invalid input: $input")
        }
    }
}

data class DayOfMonthExpression(val expression: String, val values: List<Int>) {
    companion object {
        fun parse(input: String): DayOfMonthExpression {
            if (isAsteriskExpression(input)) return DayOfMonthExpression(input, parseAsterisk(input, 1, 32))
            if (isCommaSeparatedExpression(input)) return DayOfMonthExpression(input, parseCommaSeparated(input))
            if (isRangeExpression(input)) return DayOfMonthExpression(input, parseRange(input, 1, 32))

            throw UnparsableExpressionException("Invalid input: $input")
        }
    }
}

data class MonthExpression(val expression: String, val values: List<Int>) {
    companion object {
        fun parse(input: String): MonthExpression {
            if (isAsteriskExpression(input)) return MonthExpression(input, parseAsterisk(input, 1, 13))
            if (isCommaSeparatedExpression(input)) return MonthExpression(input, parseCommaSeparated(input))
            if (isRangeExpression(input)) return MonthExpression(input, parseRange(input, 1, 13))

            throw UnparsableExpressionException("Invalid input: $input")
        }
    }
}

data class DayOfWeekExpression(val expression: String, val values: List<Int>) {
    companion object {
        fun parse(input: String): DayOfWeekExpression {
            if (isAsteriskExpression(input)) return DayOfWeekExpression(input, parseAsterisk(input, 1, 8))
            if (isCommaSeparatedExpression(input)) return DayOfWeekExpression(input, parseCommaSeparated(input))
            if (isRangeExpression(input)) return DayOfWeekExpression(input, parseRange(input, 1, 8))

            throw UnparsableExpressionException("Invalid input: $input")
        }
    }
}


class UnparsableExpressionException(message: String) : Exception(message)
