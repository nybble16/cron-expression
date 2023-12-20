package com.tomaszz.parsers.parsers

import com.tomaszz.parsers.expressionparts.UnparsableExpressionException

fun isCommaSeparatedExpression(input: String): Boolean {
    val regex = Regex("""[\d,]+""")
    return regex.matches(input)
}

fun parseCommaSeparated(input: String, lowerBound: Int, upperBound: Int): List<Int> {
    val regex = Regex("""\d+""")
    val result = mutableListOf<Int>()
    for (i in regex.findAll(input)) {
        val iInt = i.value
        if (iInt.toInt() < lowerBound || iInt.toInt() >= upperBound) throw UnparsableExpressionException("Invalid input: $input")

        result.add(iInt.toInt())
    }
    return result
}
