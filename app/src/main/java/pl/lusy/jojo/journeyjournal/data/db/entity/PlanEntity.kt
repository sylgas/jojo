package pl.lusy.jojo.journeyjournal.data.db.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "plan")
data class PlanEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Long? = null,
    var lastUpdated: Long = 0
) : DatabaseEntity
