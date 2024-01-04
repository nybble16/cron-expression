package com.tomaszz.parsers.parsers

import com.tomaszz.parsers.expressionparts.UnparsableExpressionException

class CommaSeparatedParser(private val lowerBound: Int, private val upperBound: Int) : Parser {
    override fun isParsable(input: String): Boolean {
        val regex = Regex("""\d[\d,]*""")
        return regex.matches(input)
    }

    override fun parse(input: String): List<Int> {
        val regex = Regex("""\d+""")
        val result = mutableListOf<Int>()
        for (i in regex.findAll(input)) {
            val iInt = i.value
            if (iInt.toInt() < lowerBound || iInt.toInt() >= upperBound) throw UnparsableExpressionException("Invalid input: $input")

            result.add(iInt.toInt())
        }
        return result
    }
}
