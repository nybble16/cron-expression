package com.tomaszz.parsers

fun isAsteriskExpression(input: String): Boolean {
    val regex = Regex("""\*/\d+""")
    return regex.matches(input)
}

fun parseAsterisk(input: String, upperBound: Int): List<Int> {
    val regex = Regex("""\*/(\d+)""")
    val (increment) = regex.find(input)!!.destructured
    // check for */0

    val result = mutableListOf(0)
    for (i in increment.toInt() until upperBound step increment.toInt()) {
        result.add(i)
    }
    return result
}
