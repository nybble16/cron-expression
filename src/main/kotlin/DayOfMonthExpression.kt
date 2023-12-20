package com.tomaszz

import com.tomaszz.parsers.expressionparts.CronExpression

fun main() {
    val inputString = readln()
    val cronExpression = CronExpression.parse(inputString)
    println(cronExpression)
}
