package com.tomaszz.parsers

fun isCommaSeparatedExpression(input: String): Boolean {
    val regex = Regex("""[\d,]+""")
    return regex.matches(input)
}

fun parseCommaSeparated(input: String): List<Int> {
    val regex = Regex("""[\d,]+""")
    val result = mutableListOf(0)
    for (i in regex.findAll(input)) {
        result.add(i.value.toInt())
    }
    return result
}
