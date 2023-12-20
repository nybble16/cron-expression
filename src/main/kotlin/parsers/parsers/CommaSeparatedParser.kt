package com.tomaszz.parsers.parsers

fun isCommaSeparatedExpression(input: String): Boolean {
    val regex = Regex("""[\d,]+""")
    return regex.matches(input)
}

fun parseCommaSeparated(input: String): List<Int> {
    val regex = Regex("""(\d+)(,\d+)*""")
    val result = mutableListOf<Int>()
    for (i in regex.find(input)!!.destructured.toList())
        if (i.isNotBlank()) {
            val iInt = if (i.contains(",")) i.split(",").last() else i
            result.add(iInt.toInt())
        }
    return result
}
