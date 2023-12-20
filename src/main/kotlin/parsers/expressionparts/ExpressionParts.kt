package com.tomaszz.parsers.expressionparts

import com.tomaszz.parsers.parsers.*

data class CronExpression(val minute: MinuteExpression, val hour: HourExpression, val dayOfMonth: DayOfMonthExpression, val month: MonthExpression, val dayOfWeek: DayOfWeekExpression, val command: String) {
    companion object {
        fun parse(input: String): CronExpression {
            val cmdSplit = input.split(" ", limit = 6)
            val minuteExpr = MinuteExpression.parse(cmdSplit[0])
            val hourExpr = HourExpression.parse(cmdSplit[1])
            val dayOfMonth = DayOfMonthExpression.parse(cmdSplit[2])
            val month = MonthExpression.parse(cmdSplit[3])
            val dayOfWeek = DayOfWeekExpression.parse(cmdSplit[4])
            return CronExpression(minuteExpr, hourExpr, dayOfMonth, month, dayOfWeek, cmdSplit[5])
        }
    }
}

data class MinuteExpression(val expression: String, val minutes: List<Int>) {
    companion object {
        fun parse(input: String): MinuteExpression {
            if (isAsteriskExpression(input)) return MinuteExpression(input, parseAsterisk(input, 0, 60))
            if (isCommaSeparatedExpression(input)) return MinuteExpression(input, parseCommaSeparated(input))
            if (isRangeExpression(input)) return MinuteExpression(input, parseRange(input, 0, 60))

            return MinuteExpression(input, listOf(input.toInt()))
        }
    }
}

data class HourExpression(val expression: String, val hours: List<Int>) {
    companion object {
        fun parse(input: String): HourExpression {
            if (isAsteriskExpression(input)) return HourExpression(input, parseAsterisk(input, 0, 24))
            if (isCommaSeparatedExpression(input)) return HourExpression(input, parseCommaSeparated(input))
            if (isRangeExpression(input)) return HourExpression(input, parseRange(input, 0, 24))

            return HourExpression(input, listOf(input.toInt()))
        }
    }
}

data class DayOfMonthExpression(val expression: String, val daysOfMonth: List<Int>) {
    companion object {
        fun parse(input: String): DayOfMonthExpression {
            if (isAsteriskExpression(input)) return DayOfMonthExpression(input, parseAsterisk(input, 1, 32))
            if (isCommaSeparatedExpression(input)) return DayOfMonthExpression(input, parseCommaSeparated(input))
            if (isRangeExpression(input)) return DayOfMonthExpression(input, parseRange(input, 1, 32))

            return DayOfMonthExpression(input, listOf(input.toInt()))
        }
    }
}

data class MonthExpression(val expression: String, val months: List<Int>) {
    companion object {
        fun parse(input: String): MonthExpression {
            if (isAsteriskExpression(input)) return MonthExpression(input, parseAsterisk(input, 1, 13))
            if (isCommaSeparatedExpression(input)) return MonthExpression(input, parseCommaSeparated(input))
            if (isRangeExpression(input)) return MonthExpression(input, parseRange(input, 1, 13))

            return MonthExpression(input, listOf(input.toInt()))
        }
    }
}

data class DayOfWeekExpression(val expression: String, val daysOfWeek: List<Int>) {
    companion object {
        fun parse(input: String): DayOfWeekExpression {
            if (isAsteriskExpression(input)) return DayOfWeekExpression(input, parseAsterisk(input, 1, 8))
            if (isCommaSeparatedExpression(input)) return DayOfWeekExpression(input, parseCommaSeparated(input))
            if (isRangeExpression(input)) return DayOfWeekExpression(input, parseRange(input, 1, 8))

            return DayOfWeekExpression(input, listOf(input.toInt()))
        }
    }
}
