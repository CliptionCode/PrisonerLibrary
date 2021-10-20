package util

import java.text.DateFormat
import java.time.LocalDate
import java.time.ZoneId
import java.util.*

object AppointmentUtils {
    fun getStartAndEndTime(inStartTime: LocalDate, inEndTime: LocalDate): String {
        return "${
            DateFormat.getTimeInstance(DateFormat.SHORT, Locale.getDefault())
                .format(getLocalDateToDate(inStartTime))
        } - ${
            DateFormat.getTimeInstance(DateFormat.SHORT, Locale.getDefault())
                .format(getLocalDateToDate(inEndTime))
        }"
    }

    fun isInProgress(inStartTime: LocalDate, inEndTime: LocalDate): Boolean {
        val today = System.currentTimeMillis()
        val startTimeMillis = getLocalDateInMillis(inStartTime)
        val endTimeMillis = getLocalDateInMillis(inEndTime)
        return today in startTimeMillis..endTimeMillis
    }

    fun isPlanned(inStartTime: LocalDate): Boolean {
        val today = System.currentTimeMillis()
        return today < getLocalDateInMillis(inStartTime)
    }

    fun isFinished(inEndTime: LocalDate): Boolean{
        val today = System.currentTimeMillis()
        return today >= getLocalDateInMillis(inEndTime)
    }

    fun getLocalDateInMillis(inLocalDate: LocalDate): Long {
        return Date.from(inLocalDate.atStartOfDay(ZoneId.systemDefault())?.toInstant()).time
    }

    fun getLocalDateToDate(inLocalDate: LocalDate): Date{
        return Date.from(inLocalDate.atStartOfDay(ZoneId.systemDefault())?.toInstant())
    }
}