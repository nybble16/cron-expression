package com.tomaszz.parsers.parsers

import com.tomaszz.parsers.expressionparts.ExpressionPart
import com.tomaszz.parsers.expressionparts.UnparsableExpressionException

class ExpressionParser(private val lowerBound: Int, private val upperBound: Int) {
    private val asteriskParser = AsteriskParser(lowerBound, upperBound)
    private val commaSeparatedParser = CommaSeparatedParser(lowerBound, upperBound)
    private val rangeParser = RangeParser(lowerBound, upperBound)

    fun parse(input: String): ExpressionPart {
        if (asteriskParser.isParsable(input)) return ExpressionPart(input, asteriskParser.parse(input))
        if (commaSeparatedParser.isParsable(input)) return ExpressionPart(input, commaSeparatedParser.parse(input))
        if (rangeParser.isParsable(input)) return ExpressionPart(input, rangeParser.parse(input))

        throw UnparsableExpressionException("Invalid input: $input")
    }
}
