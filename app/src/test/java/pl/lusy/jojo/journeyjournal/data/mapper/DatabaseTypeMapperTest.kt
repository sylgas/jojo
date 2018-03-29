package pl.lusy.jojo.journeyjournal.data.mapper

import org.junit.Assert.*
import org.junit.Test
import pl.lusy.jojo.journeyjournal.data.model.DayDate

class DatabaseTypeMapperTest {
    @Test
    fun testFromMillisIfNull() {
        assertNull(DatabaseTypeMapper.fromMillis(null))
    }

    @Test
    fun testFromMillisIfZero() {
        val dayDate = DatabaseTypeMapper.fromMillis(0)
        assertDayDate(dayDate, 0L, 1, 0, 1970)
    }

    @Test
    fun testFromMillisIfDayStart() {
        val dayDate = DatabaseTypeMapper.fromMillis(946684800000L)
        assertDayDate(dayDate, 946684800000L, 1, 0, 2000)
    }

    @Test
    fun testFromMillisIfOnDayEnd() {
        val dayDate = DatabaseTypeMapper.fromMillis(946681199999L)
        assertDayDate(dayDate, 946598400000L, 31, 11, 1999)
    }

    @Test
    fun testFromMillisInMiddleOfDay() {
        val dayDate = DatabaseTypeMapper.fromMillis(975675599999L)
        assertDayDate(dayDate, 975628800000L, 1, 11, 2000)
    }

    @Test
    fun testFromDayDateIfNull() {
        val millis = DatabaseTypeMapper.fromDayDate(null)
        assertEquals(null, millis)
    }

    @Test
    fun testFromDayDateIfZero() {
        val millis = DatabaseTypeMapper.fromDayDate(DayDate(1, 0, 1970))
        assertEquals(0L, millis)
    }

    @Test
    fun testFromDayDate() {
        val millis = DatabaseTypeMapper.fromDayDate(DayDate(1, 0, 2000))
        assertEquals(946684800000L, millis)
    }

    fun assertDayDate(date: DayDate?, millis: Long, day: Int, month: Int, year: Int) {
        assertNotNull(date)
        assertEquals(millis, date?.millis)
        assertEquals(day, date?.day)
        assertEquals(month, date?.month)
        assertEquals(year, date?.year)
    }
}