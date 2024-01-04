package com.tomaszz.parsers.parsers

import com.tomaszz.parsers.expressionparts.UnparsableExpressionException

class RangeParser(private val lowerBound: Int, private val upperBound: Int) : Parser {
    override fun isParsable(input: String): Boolean {
        val regex = Regex("""\d+\-\d+""")
        return regex.matches(input)
    }

    override fun parse(input: String): List<Int> {
        val regex = Regex("""(\d+)\-(\d+)""")
        val (start, finish) = regex.find(input)!!.destructured
        val result = mutableListOf<Int>()
        for (i in start.toInt()..finish.toInt())
            if (i < lowerBound || i >= upperBound)
                throw UnparsableExpressionException("Invalid input: $input")
            else result.add(i)
        return result
    }
}
