package com.tomaszz

import com.tomaszz.parsers.isAsteriskExpression
import com.tomaszz.parsers.isCommaSeparatedExpression
import com.tomaszz.parsers.parseAsterisk
import com.tomaszz.parsers.parseCommaSeparated

data class CronExpression(val minute: MinuteExpression, val hour: HourExpression, val dayOfMonth: DayOfMonthExpression, val month: String, val dayOfWeek: String, val command: String) {
    companion object {
        fun parse(input: String): CronExpression {
            val cmdSplit = input.split(" ", limit = 6)
            val minuteExpr = MinuteExpression.parse(cmdSplit[0])
            val hourExpr = HourExpression.parse(cmdSplit[1])
            val dayOfMonth = DayOfMonthExpression.parse(cmdSplit[1])
            return CronExpression(minuteExpr, hourExpr, dayOfMonth, cmdSplit[3], cmdSplit[4], cmdSplit[5])
        }
    }
}

data class MinuteExpression(val expression: String, val minutes: List<Int>) {
    companion object {
        fun parse(input: String): MinuteExpression {
            if (isAsteriskExpression(input)) return MinuteExpression(input, parseAsterisk(input, 60))
            if (isCommaSeparatedExpression(input)) return MinuteExpression(input, parseCommaSeparated(input))

            return MinuteExpression(input, listOf(input.toInt()))
        }
    }
}

data class HourExpression(val expression: String, val hours: List<Int>) {
    companion object {
        fun parse(input: String): HourExpression {
            if (isAsteriskExpression(input)) HourExpression(input, parseAsterisk(input, 24))
            if (isCommaSeparatedExpression(input)) HourExpression(input, parseCommaSeparated(input))

            return HourExpression(input, listOf(input.toInt()))
        }
    }
}

data class DayOfMonthExpression(val expression: String, val daysOfMonth: List<Int>) {
    companion object {
        fun parse(input: String): DayOfMonthExpression {
            if (isAsteriskExpression(input)) DayOfMonthExpression(input, parseAsterisk(input, 24))
            if (isCommaSeparatedExpression(input)) DayOfMonthExpression(input, parseCommaSeparated(input))

            return DayOfMonthExpression(input, listOf(input.toInt()))
        }
    }
}

fun helloWorld(): String {
    return "Hello, World!"
}

fun main() {
    val inputString = readln()
    println("Hello, World. $inputString")

    val cronExpression = CronExpression.parse(inputString)
    println(cronExpression)
}
