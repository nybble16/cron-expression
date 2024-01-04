package com.tomaszz.parsers.parsers

import com.tomaszz.parsers.expressionparts.UnparsableExpressionException

class AsteriskParser(private val lowerBound: Int, private val upperBound: Int) : Parser {
    override fun isParsable(input: String): Boolean {
        val regex = Regex("""\*|\*/\d+""")
        return regex.matches(input)
    }

    override fun parse(input: String): List<Int> {
        if (input == "*") return (lowerBound until upperBound).toList()

        val regex = Regex("""\*/(\d+)""")
        val (increment) = regex.find(input)!!.destructured
        if (increment.toInt() == 0) throw UnparsableExpressionException("Increment cannot be zero.")

        val result = mutableListOf<Int>()
        for (i in lowerBound until upperBound step increment.toInt())
            result.add(i)

        return result
    }
}
