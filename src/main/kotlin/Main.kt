package com.tomaszz

import com.tomaszz.parsers.expressionparts.CronExpression

fun main(commandLineArguments: Array<String>) {
    if (commandLineArguments.isEmpty() || commandLineArguments.size > 1) {
        println("""
            Please provide a cron expression as a single command line argument. E.g. execute the program with the following command:
                java -jar OlxCronExpression.jar "*/15 0 1,15 * 1-5 /usr/bin/find"
             """.trimIndent())
        return
    }

    val inputString = commandLineArguments[0]
    val cronExpression = CronExpression.parse(inputString)
    println(cronExpression)
}
