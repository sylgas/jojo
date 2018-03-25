package pl.lusy.jojo.journeyjournal.data.db.entity

import android.arch.persistence.room.*
import android.arch.persistence.room.ForeignKey.CASCADE
import pl.lusy.jojo.journeyjournal.data.model.DayDate

@Entity(
    tableName = "trip",
    indices = [
        Index(name = "trip_plan_index", value = ["planId"], unique = true)
    ],
    foreignKeys = [
        (ForeignKey(
            entity = PlanEntity::class,
            parentColumns = ["id"],
            childColumns = ["planId"],
            onDelete = CASCADE
        ))
    ])
data class TripEntity @Ignore constructor(
    @PrimaryKey(autoGenerate = true)
    var id: Long?,
    var planId: Long?,

    var name: String = "",
    var startDate: DayDate,
    var endDate: DayDate
) : DatabaseEntity {
    constructor() : this(null, null, "", DayDate.fromMillis(0), DayDate.fromMillis(0))
}