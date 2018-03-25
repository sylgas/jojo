package pl.lusy.jojo.journeyjournal.data.db.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import io.reactivex.Flowable
import pl.lusy.jojo.journeyjournal.data.db.entity.PlanSteps

@Dao
interface PlanDao {

    @Query("SELECT * FROM plan")
    fun getAllWithRelation(): Flowable<List<PlanSteps>>

    @Query("SELECT * FROM plan WHERE id = :id")
    fun getWithRelation(id: Long): Flowable<PlanSteps>

}