package pl.lusy.jojo.journeyjournal.data.db.entity

import android.arch.persistence.room.*
import android.arch.persistence.room.ForeignKey.CASCADE

@Entity(
    tableName = "plan_steps",
    indices = [
        Index(name = "step_plan_index", value = ["planId"])
    ],
    foreignKeys = [
        ForeignKey(
            entity = PlanEntity::class,
            parentColumns = ["id"],
            childColumns = ["planId"],
            onDelete = CASCADE
        )
    ]
)
data class PlanStepEntity @Ignore constructor(
    @PrimaryKey(autoGenerate = true)
    var id: Long?,
    var planId: Long?,

    var title: String,
    var description: String
) : DatabaseEntity {
    constructor(): this(null, null, "", "")
}
