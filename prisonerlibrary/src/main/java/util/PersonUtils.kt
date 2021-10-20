package util

import com.ascom.prisonerlibrary.model.Person
import java.text.DateFormat
import java.time.ZoneId
import java.util.*

object PersonUtils {

    fun getFormattedBirthdayTime(inPerson: Person): String {
        val birthdayDate = getBirthdayAsDate(inPerson)
        return "${
            DateFormat.getDateInstance(DateFormat.MEDIUM)
                .format(birthdayDate)
        } (${getAge(birthdayDate.time)})"
    }

    private fun getAge(inBirthdayInMillis: Long): Int {
        val dob = Calendar.getInstance(Locale.getDefault())
        dob.timeInMillis = inBirthdayInMillis
        val today = Calendar.getInstance(Locale.getDefault())
        today.time = Date()
        var age = today[Calendar.YEAR] - dob[Calendar.YEAR]
        if (today[Calendar.DAY_OF_YEAR] < dob[Calendar.DAY_OF_YEAR]) {
            age--
        }
        return age
    }

    fun showWarning(inPerson: Person): Boolean {
        return isUnderage(inPerson) || inPerson.details.behavior.violent || inPerson.details.behavior.suicide
    }

    fun isUnderage(inPerson: Person): Boolean {
        return getAge(getBirthdayAsDate(inPerson).time) < 18
    }

    fun getBirthdayAsDate(inPerson: Person): Date {
        return Date.from(
            inPerson.basic.birthDate?.atStartOfDay(ZoneId.systemDefault())?.toInstant()
        )
    }
}