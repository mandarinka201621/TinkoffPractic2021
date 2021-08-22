package com.example.koshelok.data.extentions

import android.annotation.SuppressLint
import android.content.Context
import com.example.koshelok.R
import java.sql.Date
import java.text.SimpleDateFormat
import java.util.*

fun Long.checkDate(context: Context): String {
    return getCalendar().getDay(Calendar.getInstance(), context)
}

fun Long.getCalendar(): Calendar {
    val date = Date(this)
    return GregorianCalendar().apply {
        time = date
        timeZone = TimeZone.getDefault()
    }
}

fun Calendar.getDay(nowDate: Calendar, context: Context): String {
    return if (nowDate.get(Calendar.YEAR) == get(Calendar.YEAR) &&
        nowDate.get(Calendar.DAY_OF_YEAR) == get(Calendar.DAY_OF_YEAR)
    ) context.getString(R.string.today)
    else if (nowDate.get(Calendar.YEAR) == get(Calendar.YEAR) &&
        nowDate.get(Calendar.DAY_OF_YEAR) - get(Calendar.DAY_OF_YEAR) == 1
    ) context.getString(R.string.yesterday)
    else getDayWithMonth(context)
}

fun Calendar.getDayWithMonth(context: Context): String {
    return when (get(Calendar.MONTH)) {
        Calendar.JANUARY -> context.getString(R.string.january, getDayOfMonth())
        Calendar.FEBRUARY -> context.getString(R.string.february, getDayOfMonth())
        Calendar.MARCH -> context.getString(R.string.march, getDayOfMonth())
        Calendar.APRIL -> context.getString(R.string.april, getDayOfMonth())
        Calendar.MAY -> context.getString(R.string.may, getDayOfMonth())
        Calendar.JUNE -> context.getString(R.string.june, getDayOfMonth())
        Calendar.JULY -> context.getString(R.string.july, getDayOfMonth())
        Calendar.AUGUST -> context.getString(R.string.august, getDayOfMonth())
        Calendar.SEPTEMBER -> context.getString(R.string.september, getDayOfMonth())
        Calendar.OCTOBER -> context.getString(R.string.october, getDayOfMonth())
        Calendar.NOVEMBER -> context.getString(R.string.november, getDayOfMonth())
        Calendar.DECEMBER -> context.getString(R.string.december, getDayOfMonth())
        else -> throw IllegalStateException("error number message")
    }
}

fun Calendar.getDayOfMonth(): String = this.get(Calendar.DAY_OF_MONTH).toString()

@SuppressLint("SimpleDateFormat")
fun Long.getTime(): String {
    val calendar = this.getCalendar()
    val formatter = SimpleDateFormat("HH:mm")
    return formatter.format(calendar.time)
}

@SuppressLint("SimpleDateFormat")
fun Long.getDate():String{
    val calendar = this.getCalendar()
    val formatter = SimpleDateFormat("yyyy-MM-dd")
    return formatter.format(calendar.time)
}
