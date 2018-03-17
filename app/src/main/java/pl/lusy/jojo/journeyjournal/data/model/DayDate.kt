package pl.lusy.jojo.journeyjournal.data.model

import java.text.DateFormat
import java.util.*

fun Calendar.toDayDate(): DayDate {
    val day = get(Calendar.DAY_OF_MONTH)
    val month = get(Calendar.MONTH)
    val year = get(Calendar.YEAR)
    return DayDate(day, month, year)
}

var Calendar.millis: Long
    get() = time.time
    set(value) {
        time = Date(value)
    }

fun Calendar.fromDayDate(dayDate: DayDate): Calendar {
    millis = 0L
    set(Calendar.DAY_OF_MONTH, dayDate.day)
    set(Calendar.MONTH, dayDate.month)
    set(Calendar.YEAR, dayDate.year)
    return this
}

data class DayDate(val day: Int, val month: Int, val year: Int) {
    companion object {
        fun getCurrentDate(): DayDate = Calendar.getInstance().toDayDate()

        fun fromMillis(millis: Long): DayDate {
            val calendar = Calendar.getInstance()
            calendar.millis = millis
            return calendar.toDayDate()
        }

        fun parse(dateString: String): DayDate {
            val date = DateFormat.getDateInstance().parse(dateString)
            return DayDate.fromMillis(date.time)
        }
    }

    val millis: Long
        get() = Calendar.getInstance().fromDayDate(this).millis

    override fun toString(): String {
        return DateFormat.getDateInstance().format(toDate())
    }

    fun toDate(): Date = Calendar.getInstance().fromDayDate(this).time
}
