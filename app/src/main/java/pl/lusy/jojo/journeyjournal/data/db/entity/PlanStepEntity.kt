package pl.lusy.jojo.journeyjournal.data.db.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.ForeignKey.CASCADE
import android.arch.persistence.room.PrimaryKey

@Entity(
    tableName = "plan_steps",
    foreignKeys = [
        ForeignKey(
            entity = PlanEntity::class,
            parentColumns = ["id"],
            childColumns = ["planId"],
            onDelete = CASCADE
        )
    ]
)

data class PlanStepEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Long? = null,
    var planId: Long? = null,

    var title: String = "",
    var description: String = ""
) : DatabaseEntity
