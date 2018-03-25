package pl.lusy.jojo.journeyjournal.data.db

import io.reactivex.Flowable
import pl.lusy.jojo.journeyjournal.data.db.dao.PlanDao
import pl.lusy.jojo.journeyjournal.data.db.entity.PlanSteps
import javax.inject.Inject

class PlanRoomDatabase @Inject constructor(
    private val planDao: PlanDao
) : PlanDatabase {
    override fun getAllWithRelation(): Flowable<List<PlanSteps>> =
        planDao.getAllWithRelation()

    override fun getWithRelation(id: Long): Flowable<PlanSteps> =
        planDao.getWithRelation(id)

}