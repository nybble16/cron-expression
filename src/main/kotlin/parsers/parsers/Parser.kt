package com.tomaszz.parsers.parsers

interface Parser {
    fun isParsable(input: String): Boolean
    fun parse(input: String): List<Int>
}
