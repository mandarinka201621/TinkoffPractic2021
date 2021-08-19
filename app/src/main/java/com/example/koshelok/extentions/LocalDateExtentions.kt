package com.example.koshelok.extentions

import android.content.Context
import com.example.koshelok.R
import kotlinx.datetime.DatePeriod
import kotlinx.datetime.LocalDate
import kotlinx.datetime.minus

private const val JANUARY = 1
private const val FEBRUARY = 2
private const val MARCH = 3
private const val APRIL = 4
private const val MAY = 5
private const val JUNE = 6
private const val JULY = 7
private const val AUGUST = 8
private const val SEPTEMBER = 9
private const val OCTOBER = 10
private const val NOVEMBER = 11
private const val DECEMBER = 12

fun LocalDate.getDayWithMonth(context: Context): String {
    return when (this.monthNumber) {
        JANUARY -> context.getString(R.string.january, dayOfMonth.toString())
        FEBRUARY -> context.getString(R.string.february, dayOfMonth.toString())
        MARCH -> context.getString(R.string.march, dayOfMonth.toString())
        APRIL -> context.getString(R.string.april, dayOfMonth.toString())
        MAY -> context.getString(R.string.may, dayOfMonth.toString())
        JUNE -> context.getString(R.string.june, dayOfMonth.toString())
        JULY -> context.getString(R.string.july, dayOfMonth.toString())
        AUGUST -> context.getString(R.string.august, dayOfMonth.toString())
        SEPTEMBER -> context.getString(R.string.september, dayOfMonth.toString())
        OCTOBER -> context.getString(R.string.october, dayOfMonth.toString())
        NOVEMBER -> context.getString(R.string.november, dayOfMonth.toString())
        DECEMBER -> context.getString(R.string.december, dayOfMonth.toString())
        else -> throw IllegalStateException("error number message")
    }
}

fun LocalDate.getDay(newDate: LocalDate, context: Context): String {
    return when (minus(newDate)) {
        DatePeriod(0, 0, 0) -> context.getString(R.string.today)
        DatePeriod(0, 0, 1) -> context.getString(R.string.yesterday)
        else -> getDayWithMonth(context)
    }
}
