package pl.lusy.jojo.journeyjournal.data.model

data class Trip(
    val id: Long? = null,
    val planId: Long? = null,

    val name: String = "",
    val startDate: DayDate = DayDate.getCurrentDate(),
    val endDate: DayDate = DayDate.getCurrentDate()
)
