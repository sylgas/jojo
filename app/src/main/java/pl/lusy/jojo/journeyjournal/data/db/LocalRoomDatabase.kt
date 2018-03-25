package pl.lusy.jojo.journeyjournal.data.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import pl.lusy.jojo.journeyjournal.data.db.dao.PlanDao
import pl.lusy.jojo.journeyjournal.data.db.dao.TripDao
import pl.lusy.jojo.journeyjournal.data.db.entity.PlanEntity
import pl.lusy.jojo.journeyjournal.data.db.entity.PlanStepEntity
import pl.lusy.jojo.journeyjournal.data.db.entity.TripEntity
import pl.lusy.jojo.journeyjournal.data.mapper.DatabaseTypeMapper

@Database(
    entities = [
        PlanEntity::class,
        PlanStepEntity::class,
        TripEntity::class
    ],
    version = 1
)
@TypeConverters(DatabaseTypeMapper::class)
abstract class LocalRoomDatabase : RoomDatabase() {
    abstract fun getPlanDao(): PlanDao
    abstract fun getTripDao(): TripDao
}
