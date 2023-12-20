package com.tomaszz.parsers.parsers

import com.tomaszz.parsers.expressionparts.UnparsableExpressionException

fun isAsteriskExpression(input: String): Boolean {
    val regex = Regex("""\*|\*/\d+""")
    return regex.matches(input)
}

fun parseAsterisk(input: String, lowerBound: Int, upperBound: Int): List<Int> {
    if (input == "*") return (lowerBound until upperBound).toList()

    val regex = Regex("""\*/(\d+)""")
    val increment = (regex.find(input)!!.destructured).component1().toInt()
    if (increment == 0) throw UnparsableExpressionException("Increment cannot be zero.")

    val result = mutableListOf<Int>()
    for (i in lowerBound until upperBound step increment)
        result.add(i)

    return result
}
