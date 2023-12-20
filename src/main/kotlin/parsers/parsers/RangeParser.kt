package com.tomaszz.parsers.parsers

fun isRangeExpression(input: String): Boolean {
//    val regex = Regex("""\d+\\-\d+""")
    val regex = Regex("""\d+\-\d+""")
    return regex.matches(input)
}

fun parseRange(input: String, lowerBound: Int, upperBound: Int): List<Int> {
    val regex = Regex("""(\d+)\-(\d+)""")
    val (start, finish) = regex.find(input)!!.destructured
    val result = mutableListOf<Int>()
    for (i in start.toInt()..finish.toInt())
        if (i < lowerBound || i >= upperBound) break
        else result.add(i)
    return result
}