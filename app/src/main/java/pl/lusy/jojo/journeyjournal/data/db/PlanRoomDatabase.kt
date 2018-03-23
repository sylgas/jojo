package pl.lusy.jojo.journeyjournal.data.db

import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import pl.lusy.jojo.journeyjournal.data.entity.PlanEntity
import pl.lusy.jojo.journeyjournal.data.entity.PlanStepEntity

class PlanRoomDatabase : PlanDatabase {

    private val planStepMock = listOf(
        PlanStepEntity("Step1", "Najwazniejszy"),
        PlanStepEntity("Step2", null),
        PlanStepEntity("Step3", "")
    )

    private val plansMock = listOf(
        PlanEntity(planStepMock)
    )

    override fun get(id: Long): Flowable<PlanEntity> {
        return Flowable.create<PlanEntity>({ emmiter ->
            emmiter.onNext(plansMock.first())
        }, BackpressureStrategy.LATEST)
    }

    override fun getAll(): Flowable<List<PlanEntity>> {
        return Flowable.create<List<PlanEntity>>({ emmiter ->
            emmiter.onNext(plansMock)
        }, BackpressureStrategy.LATEST)
    }

}