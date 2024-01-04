package com.tomaszz.parsers.parsers

object ParserFactory {
    // move to a Properties file
    private const val MINUTE_RANGE_MIN = 0
    private const val MINUTE_RANGE_MAX = 60
    private const val HOUR_RANGE_MIN = 0
    private const val HOUR_RANGE_MAX = 24
    private const val DAY_OF_MONTH_RANGE_MIN = 1
    private const val DAY_OF_MONTH_RANGE_MAX = 32
    private const val MONTH_RANGE_MIN = 1
    private const val MONTH_RANGE_MAX = 13
    private const val DAY_OF_WEEK_RANGE_MIN = 1
    private const val DAY_OF_WEEK_RANGE_MAX = 8

    fun getMinuteParser() = ExpressionParser(MINUTE_RANGE_MIN, MINUTE_RANGE_MAX)
    fun getHourParser() = ExpressionParser(HOUR_RANGE_MIN, HOUR_RANGE_MAX)
    fun getDayParser() = ExpressionParser(DAY_OF_MONTH_RANGE_MIN, DAY_OF_MONTH_RANGE_MAX)
    fun getMonthParser() = ExpressionParser(MONTH_RANGE_MIN, MONTH_RANGE_MAX)
    fun getDayOfWeekParser() = ExpressionParser(DAY_OF_WEEK_RANGE_MIN, DAY_OF_WEEK_RANGE_MAX)
}
