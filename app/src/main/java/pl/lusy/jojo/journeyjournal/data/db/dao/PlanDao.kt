package pl.lusy.jojo.journeyjournal.data.db.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import android.arch.persistence.room.Transaction
import io.reactivex.Flowable
import pl.lusy.jojo.journeyjournal.data.db.entity.PlanSteps

@Dao
interface PlanDao {
    @Transaction
    @Query("SELECT * FROM plan WHERE id = :id")
    fun getWithRelation(id: Long): Flowable<PlanSteps>

    @Transaction
    @Query("SELECT * FROM plan")
    fun getAllWithRelation(): Flowable<List<PlanSteps>>

}