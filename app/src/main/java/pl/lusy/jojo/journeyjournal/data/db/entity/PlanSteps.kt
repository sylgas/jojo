package pl.lusy.jojo.journeyjournal.data.db.entity

import android.arch.persistence.room.Embedded
import android.arch.persistence.room.Relation

data class PlanSteps(
    @Embedded var plan: PlanEntity? = null,
    @Relation(parentColumn = "id", entityColumn = "planId")
    var planSteps: List<PlanStepEntity> = emptyList()
) : EntityRelation
