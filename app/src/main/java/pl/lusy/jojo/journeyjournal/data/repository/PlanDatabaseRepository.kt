package pl.lusy.jojo.journeyjournal.data.repository

import io.reactivex.Flowable
import pl.lusy.jojo.journeyjournal.data.db.PlanDatabase
import pl.lusy.jojo.journeyjournal.data.mapper.toPlan
import pl.lusy.jojo.journeyjournal.data.model.Plan
import javax.inject.Inject

class PlanDatabaseRepository @Inject constructor(
    private val database: PlanDatabase
) : PlanRepository {

    override fun get(id: Long): Flowable<Plan> =
        database.getWithRelation(id).map { it.toPlan() }

}