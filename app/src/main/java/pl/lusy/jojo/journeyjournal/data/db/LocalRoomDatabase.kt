package io.github.droidkaigi.confsched2018.data.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import pl.lusy.jojo.journeyjournal.data.db.dao.PlanDao
import pl.lusy.jojo.journeyjournal.data.db.entity.PlanEntity
import pl.lusy.jojo.journeyjournal.data.db.entity.PlanStepEntity

@Database(
    entities = [
        PlanEntity::class,
        PlanStepEntity::class
    ],
    version = 1
)
abstract class LocalRoomDatabase : RoomDatabase() {
    abstract fun getPlanDao(): PlanDao
}
