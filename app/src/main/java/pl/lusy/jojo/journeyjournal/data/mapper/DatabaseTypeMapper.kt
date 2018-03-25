package pl.lusy.jojo.journeyjournal.data.mapper

import android.arch.persistence.room.TypeConverter
import pl.lusy.jojo.journeyjournal.data.model.DayDate

object DatabaseTypeMapper {
    @TypeConverter
    @JvmStatic
    fun fromMillis(millis: Long?): DayDate? =
        if (millis == null) null else DayDate.fromMillis(millis)

    @TypeConverter
    @JvmStatic
    fun fromDayDate(dayDate: DayDate?): Long? = dayDate?.millis
}