package pl.lusy.jojo.journeyjournal.data.model

data class Trip(
    val id: Long? = null,
    val planId: Long? = null,

    val name: String = "",
    val startDate: DayDate = DayDate.getCurrentDate(),
    val endDate: DayDate = DayDate.getCurrentDate()
) {
    fun update(id: Long? = this.id,
               planId: Long? = this.planId,
               name: String = this.name,
               startDate: DayDate = this.startDate,
               endDate: DayDate = this.endDate
    ) = Trip(id, planId, name, startDate, endDate)
}