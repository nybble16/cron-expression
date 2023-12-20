package com.tomaszz

import com.tomaszz.parsers.expressionparts.CronExpression

fun main(ocmmandLineArguments: Array<String>) {
    val inputString = ocmmandLineArguments[0]
    val cronExpression = CronExpression.parse(inputString)
    println(cronExpression)
}
