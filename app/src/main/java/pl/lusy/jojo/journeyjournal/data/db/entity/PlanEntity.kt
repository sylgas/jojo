package pl.lusy.jojo.journeyjournal.data.db.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.Ignore
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "plan")
data class PlanEntity @Ignore constructor(
    @PrimaryKey(autoGenerate = true)
    var id: Long?,
    var lastUpdated: Long
) : DatabaseEntity {
    constructor() : this(null, 0)
}
