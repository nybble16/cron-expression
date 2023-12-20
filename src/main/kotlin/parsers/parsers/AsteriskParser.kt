package com.tomaszz.parsers.parsers

fun isAsteriskExpression(input: String): Boolean {
    val regex = Regex("""\*|\*/\d+""")
    return regex.matches(input)
}

fun parseAsterisk(input: String, lowerBound: Int, upperBound: Int): List<Int> {
    if (input == "*") return (lowerBound until upperBound).toList()

    val regex = Regex("""\*/(\d+)""")
    val increment = (regex.find(input)!!.destructured).toList().last().toInt()
    // TODO: check for */0

    val result = mutableListOf(lowerBound)
    for (i in lowerBound + increment until upperBound step increment) {
        result.add(i)
    }
    return result
}
