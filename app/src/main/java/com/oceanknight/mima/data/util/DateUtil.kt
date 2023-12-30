package com.oceanknight.mima.data.util

import android.content.Context
import com.oceanknight.mima.R
import java.time.LocalDate
import java.time.format.DateTimeFormatter

/**
 * @author Oceanknight
 * @date 2023/12/30 22:31
 * @describe
 */
object DateUtil {
    fun getCurrentDayAsString(): String {
        val now = LocalDate.now()
        return now.dayOfMonth.toString()
    }

    fun getCurrentMonthAsString(): String {
        val now = LocalDate.now()
        return now.month.toString()
    }

    fun getCurrentMonthShorthandAsString(): String {
        val now = LocalDate.now()
        val formatter = DateTimeFormatter.ofPattern("MMM")
        return now.format(formatter)
    }

    fun getCurrentDayOfWeekAsString(context: Context): String {
        val now = LocalDate.now()
        when(now.dayOfWeek.toString()) {
            "MONDAY" -> return context.getString(R.string.monday)
            "TUESDAY" -> return context.getString(R.string.tuesday)
            "WEDNESDAY" -> return context.getString(R.string.wednesday)
            "THURSDAY" -> return context.getString(R.string.thursday)
            "FRIDAY" -> return context.getString(R.string.friday)
            "SATURDAY" -> return context.getString(R.string.saturday)
            "SUNDAY" -> return context.getString(R.string.sunday)
        }
        return context.getString(R.string.something_wrong)
    }


}